package home.masterserver;

import org.springframework.boot.SpringApplication;

import home.masterserver.other.Database;
import home.masterserver.controller.AccountsController;
public class Main {
    public static void main(String[] args) throws Exception {
        Database.connect();
        SpringApplication.run(AccountsController.class, args);
    }
}