package org.example.Exercices.exo1;

import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Preferablement faire une chaine pour la date, par facilité.
                        /*
                ## Exercice JDBC 1

                        - Réalisez une application en java qui demande à l'utilisateur de saisir :
                        - Nom
                        - Prénom
                        - numéro de classe
                - Date de diplôme
                - L'application ajoutera les données dans une table etudiant.

                        - On souhaite modifier notre application pour ajouter les fonctionnalités suivantes :
                - Afficher la totalité des etudiants.
                - Afficher les etudiants d'une classes.
                        - Supprimer un etudiant. */

        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
        try {
            connection = ConnectionUtilsEXO1old.getSQLConnection();
            if (connection != null) {
                System.out.println("On vient de se connecter à la BDD!!!");

                System.out.println("Merci de saisir le prénom : ");
                String firstName = scanner.nextLine();

                System.out.println("Merci de saisir le nom : ");
                String lastName = scanner.nextLine();

                System.out.println("Merci de saisir son numéro de classe : ");
                int classe = scanner.nextInt();
                scanner.nextLine(); // Utiilsation du retour chariot parce que le nextInt ne le fait
                System.out.println("Merci de saisir la date de diplôme (Au format JJ-MM-AAAA, préférablement)");
                String date = scanner.nextLine();


                String request = "INSERT INTO etudiant (first_name,last_name,classe,date) values (?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setInt(3, classe);
                preparedStatement.setString(4, date);
                int nbrRows = preparedStatement.executeUpdate(); // retour int qui correspond au nombre de lignes affectés
                ResultSet resultSet = preparedStatement.getGeneratedKeys(); //
                System.out.println("Nombre de ligne : " + nbrRows);
                if (resultSet.next()) {
                    System.out.println("Id de la ligne insérée : " + resultSet.getInt(1));
                }
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