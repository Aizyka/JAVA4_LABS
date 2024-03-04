package home.masterserver.controller;

import home.masterserver.model.Platform;
import home.masterserver.model.Region;
import home.masterserver.model.User;
import home.masterserver.model.UserProfile;
import home.masterserver.other.Hasher;
import home.masterserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/login")
    public ResponseEntity<String> login(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("platform") String platform) {
        String hashed = Hasher.hashPassword(password);
        if(!userService.existsPlatform(platform))
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        if(!userService.existsUser(login,hashed))
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        User user = userService.getUser(login, hashed);
        UserProfile userProfile = user.getProfile();
        userProfile.setSecret(Hasher.generateRandomHash());
        userProfile.setLoginPlatform(userService.getPlatform(platform));
        userProfile.setLoginDate(LocalDateTime.now());
        userService.save(userProfile);
        return new ResponseEntity<>(userProfile.getSecret(), HttpStatus.OK);
    }
    @PostMapping(path = "/register")
    public ResponseEntity<String> register(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("platform") String platform) {
        if(userService.existsUser(login))
        {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
        if(!userService.existsPlatform(platform))
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        UserProfile userProfile = new UserProfile();
        userProfile.setName(login);
        userProfile.setSecret(Hasher.generateRandomHash());
        userProfile.setCreationPlatform(userService.getPlatform(platform));
        userProfile.setLoginPlatform(userService.getPlatform(platform));
        userProfile.setRegion(userService.getRegion("Europe"));
        userService.save(userProfile);

        User user = new User();
        user.setLogin(login);
        user.setPassword(Hasher.hashPassword(password));
        user.setProfile(userProfile);

        userService.save(user);
        return new ResponseEntity<>(userProfile.getSecret(), HttpStatus.OK);
    }
    @PatchMapping(path = "/changePassword")
    public ResponseEntity<User> changePassword(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("newPassword") String newPassword) {
        String hashed = Hasher.hashPassword(password);
        if(!userService.existsUser(login,hashed))
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        User user = userService.getUser(login,hashed);
        user.setPassword(Hasher.hashPassword(newPassword));
        userService.save(user);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    @DeleteMapping(path = "/delete")
    public ResponseEntity<User> deleteAccount(@RequestParam("login") String login, @RequestParam("password") String password) {
        String hashed = Hasher.hashPassword(password);
        if(!userService.existsUser(login,hashed))
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        userService.delete(userService.getUser(login, hashed));
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
