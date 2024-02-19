package home.masterserver;

import org.json.JSONObject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
@RestController
@EnableAutoConfiguration
public class Mapping {
    @GetMapping(path = "/getUsersCount")
    String getUsersCount()
    {
        JSONObject json = new JSONObject();
        Database.Query query = new Database.Query("SELECT COUNT(*) FROM public.\"Accounts\"");
        int count = 0;
        try {
            while(query.getResult().next()) {
                count = query.getResult().getInt(1);
            }
            query.close();
            json.put("code", "CS_0");
            json.put("count", count);
        }
        catch (SQLException e) {
            json.put("code", "CS_201");
            json.put("description", e.getMessage());
        }
        return json.toString();
    }
}
