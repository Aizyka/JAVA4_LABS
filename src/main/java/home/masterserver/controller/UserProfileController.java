package home.masterserver.controller;

import home.masterserver.model.UserProfile;
import home.masterserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class UserProfileController {
    private final UserService userService;
    @Autowired
    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/get")
    public ResponseEntity<UserProfile> get(@RequestParam("secret") String secret) {
        if(!userService.existUserProfile(secret))
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(userService.getUserProfile(secret), HttpStatus.OK);
    }
    @PatchMapping(path = "/updateName")
    public ResponseEntity<UserProfile> updateName(@RequestParam("secret") String secret, @RequestParam("newName") String newName) {
        if(!userService.existUserProfile(secret))
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        UserProfile userProfile = userService.getUserProfile(secret);
        userProfile.setName(newName);
        userService.save(userProfile);
        return new ResponseEntity<>(userProfile, HttpStatus.OK);
    }
}
