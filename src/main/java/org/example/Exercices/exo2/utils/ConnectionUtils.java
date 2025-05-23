package org.example.Exercices.exo2.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// C'est ici qu'on doit gérer l'authentification

public class ConnectionUtils {
    private final String url = "jdbc:mysql://localhost:3306/jdbc_exo2";
    private final String user = "root";
    private final String password = "tony"; //


    public Connection getSQLConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
        // preparation pour se connecter à la bdd

    }
}
