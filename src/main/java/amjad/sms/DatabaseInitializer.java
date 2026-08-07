package amjad.sms;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initialize() {
        String sql = """
                CREATE TABLE IF NOT EXISTS students (
                    id INTEGER PRIMARY KEY, name TEXT NOT NULL, program TEXT NOT NULL
                );
                """;

        try (Connection conn = DatabaseConfig.gConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Database initialzed successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
