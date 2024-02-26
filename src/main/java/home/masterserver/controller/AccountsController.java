package home.masterserver.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import home.masterserver.service.DatabaseService;

import java.util.Map;

@RestController
@EnableAutoConfiguration
public class AccountsController {
    @GetMapping(path = "/getUsersCount")
    public ResponseEntity<Map<String, Object>> getUsersCount() {
        return new ResponseEntity<>(DatabaseService.getUsersCount(), HttpStatus.OK);
    }

    @GetMapping(path = "/getFetchedUsers")
    public ResponseEntity<Map<String, Object>> getFetchedUsers(@RequestParam("authorized") boolean authorized) {
        return new ResponseEntity<>(DatabaseService.getFetched(authorized), HttpStatus.OK);
    }
}
