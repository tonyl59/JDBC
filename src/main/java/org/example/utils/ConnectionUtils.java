package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    public static Connection getSQLConnection() throws SQLException {
        // preparation pour se connecter à la bdd
        String url = "jdbc:mysql://localhost:3306/demo_jdbc";
        String username = "root";
        String password = "tony"; // Changer le mdp

        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }
}
