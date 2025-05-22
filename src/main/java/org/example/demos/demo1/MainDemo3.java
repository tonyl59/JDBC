package org.example.demos.demo1;
import org.example.utils.ConnectionUtils;

import java.sql.*;

public class MainDemo3{
    public static void main(String[] args) {
        // Recuperation de données
        Connection connection = null;
        String request = "SELECT * FROM users";

        try {
            connection = ConnectionUtils.getSQLConnection();
        /*    Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()){
                System.out.println("La colonne id : "+resultSet.getInt("id"));
                System.out.println("La colonne first_name : "+resultSet.getString("first_name"));
                System.out.println("La colonne last_name : "+resultSet.getString("last_name"));
            } */
            String request2 = "SELECT * FROM users where id = ?";
            PreparedStatement statement = connection.prepareStatement(request2);
            statement.setInt(1,2);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                System.out.println("La personne avec l'id numero 2 : ");
                System.out.println("Son nom "+resultSet.getString("first_name"));
                System.out.println("Son prenom "+resultSet.getString("last_name"));
                System.out.println();
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally{
            if(connection != null){
                try{
                    connection.close();
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
