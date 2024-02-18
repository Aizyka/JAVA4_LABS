package home.masterserver;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;

public class DatabaseConfig {
    private static final Properties properties = new Properties();

    static {
        try (FileInputStream input = new FileInputStream(new File("database.properties"))) {
            if (input == null) {
                System.out.println("Cant open database.properties");
                System.exit(1);
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDbUrl() {

        return properties.getProperty("database.url");
    }

    public static String getDbUsername() {
        return properties.getProperty("database.username");
    }

    public static String getDbPassword() {
        return properties.getProperty("database.password");
    }
}
