package org.example.demos.demo1;

import org.example.utils.ConnectionUtils;

import java.sql.*;
import java.util.Scanner;

public class MainDemo2 {
    public static void main(String[] args) {

        try {
            Connection connection = ConnectionUtils.getSQLConnection();
            if (connection != null){
                System.out.println("Yep ca fonctionne!");
            }else{
                System.out.println("Il faut verifier que les infos sont corrects");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
        try {
            connection = ConnectionUtils.getSQLConnection();
            System.out.println("On vient de se connecter à la BDD!!!");
            System.out.println("Merci de saisir le prénom : ");
            String firstName = scanner.nextLine();
            System.out.println("Merci de saisir le nom : ");
            String lastName = scanner.nextLine();
            // Une requete pour l'insertion des données
            //String request = "INSERT INTO users (first_name, last_name) values ('"+firstName+"','"+lastName+"')";
            //System.out.println("Voici la requete que je vais faire : "+request);
            // Facon 1 => execution d'une requête sans retour NON CONSEILLE JUSTE POUR DEMONSTRATION


            // Attention danger injection SQL avec ce systeme (variable dans la chaine de caractère)
/*          Statement statement = connection.createStatement();
            statement.execute(request);
            System.out.println("Requête executée"); */


            //Facon 2 => Avec une requete préparée

            // Version sans récuperation de l'id auto genere
            /*
            String request = "INSERT INTO users (first_name,last_name) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            // preparedStatement.execute(); // retour boolean -> Je l'enleve sinon je met deux fois ma ligne
            int nbrRows = preparedStatement.executeUpdate(); // retour int qui correspond au nombre de lignes affectés
            System.out.println("Nombre de ligne : "+nbrRows);
            */


            // Version avec recuperation de l'id auto généré
            String request = "INSERT INTO users (first_name,last_name) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(request,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            int nbrRows = preparedStatement.executeUpdate(); // retour int qui correspond au nombre de lignes affectés
            ResultSet resultSet = preparedStatement.getGeneratedKeys(); // TODO Yamine a du se tromper ici
            System.out.println("Nombre de ligne : "+nbrRows);
            if(resultSet.next()){
                System.out.println("Id de la ligne insérée : " + resultSet.getInt(1));

            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            // fermer la connexion dans le bloc finally pour garantir sa fermeture
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
