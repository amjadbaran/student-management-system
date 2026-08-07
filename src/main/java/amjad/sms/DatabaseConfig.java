package amjad.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String URL = "jdbc:sqlite:sms.db";

    public static Connection gConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
