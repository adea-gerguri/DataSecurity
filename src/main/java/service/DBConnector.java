package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static String URL = "jdbc:mysql://localhost:3306/datasecurity";
    private static String USER = "root";
    private static String PASSWORD = "080893";
    private static Connection connection = null;

    public static Connection getConnection(){
        if(connection == null){
            try {
                connection = DriverManager.getConnection(
                        URL, USER, PASSWORD
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
