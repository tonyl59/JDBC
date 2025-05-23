package org.example.Exercices.exo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtilsEXO1 {
    public static Connection getSQLConnection() throws SQLException {
        // preparation pour se connecter à la bdd
        String url = "jdbc:mysql://localhost:3306/exo1";
        String username = "root";
        String password = "tony"; // Changer le mdp

        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }
}
