package org.example.demos.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainDemo1 {
    public static void main(String[] args) {
        // 1 creation nouveau projet
        // File => new => projet =>

        //2 Ajout dependencies maven :
        // Ne pas oublier de mettre rajouter la balise <dependencies>
        // dans la fichier pom.xml, a la racine du projet

        //3 Ajouter le connector correspondant a ma BDD
        // https://mvnrepository.com/
        // une fois la dependance rajouté entre les balises dependences
        // Je recharge le projet

        // je peux verifier la presence de la nouvelle librairie
        // en regardant les external librairies presentes sur intelijj

        // Preparation pour se connecter à la BDD
        String url = "jdbc:mysql://localhost:3306/demo_jdbc";
        String username = "root";
        String password = "r"; // Changer le mdp

        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            if (connection != null){
                System.out.println("Connexion est ok !!");
            }else {
                System.out.println("Connexion echoué");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
