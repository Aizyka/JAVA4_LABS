package home.masterserver.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

import home.masterserver.other.Database;

@Service
public class DatabaseService {

    private DatabaseService() {
        throw new IllegalStateException("Utility class");
    }
    public static JSONObject getUsersCount() {
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
        return json;
    }
}
