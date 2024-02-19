package home.masterserver;
import java.sql.*;

public class Database {
    public static class Query {
        private Statement statement;
        private ResultSet result;

        public Query(String query)
        {
            try {
                statement = Database.connection.createStatement();
                result = statement.executeQuery(query);
            }
            catch (SQLException e) {
                Log.message(e.getMessage());
            }
        }

        public ResultSet getResult() {
            return result;
        }

        public void close() {
            try {
                result.close();
                statement.close();
            }
            catch (SQLException e) {
                Log.message(e.getMessage());
            }
        }
    }
    static Connection connection;

    private Database() {
        throw new IllegalStateException("Utility class");
    }

    public static void connect() throws SQLException {

        try {
            var jdbcUrl = DatabaseConfig.getDbUrl();
            var user = DatabaseConfig.getDbUsername();
            var password = DatabaseConfig.getDbPassword();

            connection = DriverManager.getConnection(jdbcUrl, user, password);

        } catch (SQLException  e) {
            Log.message(e.getMessage());
        }
    }
}
