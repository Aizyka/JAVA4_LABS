package home.masterserver.service;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Map;
import java.util.HashMap;

import home.masterserver.other.Database;

@Service
public class DatabaseService {
    private DatabaseService() {
        throw new IllegalStateException("Utility class");
    }

    static Map<String, Object> getCount(Database.Query query) {
        Map<String, Object> json = new HashMap<>();
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

    public static Map<String, Object> getUsersCount() {
        Database.Query query = new Database.Query("SELECT COUNT(*) FROM public.\"Accounts\"");
        return getCount(query);
    }

    public static Map<String, Object> getFetched(boolean authorized) {
        Database.Query query;
        if(authorized)
            query = new Database.Query("SELECT COUNT(*) FROM public.\"Accounts\" WHERE email_secret LIKE ''");
        else
            query = new Database.Query("SELECT COUNT(*) FROM public.\"Accounts\" WHERE email_secret NOT LIKE ''");
        return getCount(query);
    }
}
