package home.masterserver.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import home.masterserver.service.DatabaseService;
@RestController
@EnableAutoConfiguration
public class AccountsController {
    @GetMapping(path = "/getUsersCount")
    String getUsersCount()
    {
        return DatabaseService.getUsersCount().toString();
    }

    @GetMapping(path = "/getFetchedUsers")
    String getUsersCount(@RequestParam("authorized") boolean authorized)
    {
        return DatabaseService.getFetched(authorized).toString();
    }
}
