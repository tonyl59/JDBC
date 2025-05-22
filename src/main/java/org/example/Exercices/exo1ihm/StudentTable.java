package org.example.Exercices.exo1ihm;

import java.sql.*;
import java.util.Scanner;


public class StudentTable {


    public static void add_student(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
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

    public static void display_all(Connection connection) throws SQLException {

        String request = "SELECT * FROM etudiant";
        PreparedStatement statement = connection.prepareStatement(request);
        statement.setInt(1, 2);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            System.out.println("La personne avec l'id numero 2 : ");
            System.out.println("Son nom " + resultSet.getString("first_name"));
            System.out.println("Son prenom " + resultSet.getString("last_name"));
            System.out.println();
            ;
        }
    /*
    public static void display_in_class(Connection connection) throws SQLException{
        ;
    }

    public static void remove_student(Connection connection)throws SQLException{{
    ;}
        }
    } */
    }
}
