package jm.task.core.jdbc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/mydbtest";
    private Connection connection;

    public Util() {}

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }



}
