package home.masterserver;

import org.springframework.boot.SpringApplication;

public class Main {
    public static void main(String[] args) throws Exception {
        Database.connect();
        SpringApplication.run(Mapping.class, args);
    }
}