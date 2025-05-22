package org.example.Exercices.exo1ihm;

import org.example.Exercices.exo1.ConnectionUtilsEXO1old;

import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        IHM ihm = new IHM();
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
        try {
            connection = ConnectionUtilsEXO1old.getSQLConnection();
            if (connection != null) {
                System.out.println("On vient de se connecter à la BDD!!!");
                ihm.start(connection);
            }



        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            if (connection != null){
                try {
                    connection.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }


    }
        }
    }
}