package home.masterserver.controller;

import org.json.JSONObject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import home.masterserver.service.DatabaseService;
@RestController
@EnableAutoConfiguration
public class AccountsController {
    @GetMapping(path = "/getUsersCount")
    String getUsersCount()
    {
        return DatabaseService.getUsersCount().toString();
    }
}
