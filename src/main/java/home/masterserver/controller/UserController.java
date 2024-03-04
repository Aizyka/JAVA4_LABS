package home.masterserver.controller;

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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if(!userService.existsUser(login,hashed))
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
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
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        if(!userService.existsPlatform(platform))
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        User user = userService.getUser(login,hashed);
        user.setPassword(Hasher.hashPassword(newPassword));
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @DeleteMapping(path = "/delete")
    public ResponseEntity<Void> deleteAccount(@RequestParam("login") String login, @RequestParam("password") String password) {
        String hashed = Hasher.hashPassword(password);
        if(!userService.existsUser(login,hashed))
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        userService.delete(userService.getUser(login, hashed));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
