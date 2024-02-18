package home.masterserver;
import java.sql.*;

public class Database {
    public static class Query {
        private Statement statement;
        public ResultSet result;

        public Query(String query)
        {
            try {
                statement = Database.connection.createStatement();
                result = statement.executeQuery(query);
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        public void Close() {
            try {
                result.close();
                statement.close();
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    static Connection connection;
    public static void connect() throws SQLException {

        try {
            var jdbcUrl = DatabaseConfig.getDbUrl();
            var user = DatabaseConfig.getDbUsername();
            var password = DatabaseConfig.getDbPassword();

            connection = DriverManager.getConnection(jdbcUrl, user, password);

        } catch (SQLException  e) {
            System.err.println(e.getMessage());
        }
    }
}
