package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionConfiguration {

    public static Connection conn;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Failed to connect to database!!!");
            e.printStackTrace();
        }
    }
}
