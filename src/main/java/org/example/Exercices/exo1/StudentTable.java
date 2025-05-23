package org.example.Exercices.exo1;

import java.sql.*;
import java.util.Scanner;


public class StudentTable {
    static Scanner scanner = new Scanner(System.in);


    public static void add_student(Connection connection) throws SQLException {
        System.out.println("Please input first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Please input last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Please input student's class number : ");
        int classe = scanner.nextInt();
        scanner.nextLine(); // Utiilsation du retour chariot parce que le nextInt ne le fait
        System.out.println("Please input student's diploma date (DD-MM-YYYY format preferably)");
        String date = scanner.nextLine();


        String request = "INSERT INTO etudiant (first_name,last_name,classe,date) values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setInt(3, classe);
        preparedStatement.setString(4, date);
        int nbrRows = preparedStatement.executeUpdate(); // retour int qui correspond au nombre de lignes affectés
        ResultSet resultSet = preparedStatement.getGeneratedKeys(); //
        System.out.println("Number of lines: " + nbrRows);
        if (resultSet.next()) {
            System.out.println("ID of inserted line : " + resultSet.getInt(1));
        }
    }

    public static void display_all(Connection connection) throws SQLException {

        String request = "SELECT * FROM etudiant";
        PreparedStatement statement = connection.prepareStatement(request);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.print("[id: " + resultSet.getString("id"));
            System.out.print("] prenom: " + resultSet.getString("first_name"));
            System.out.print(" | nom: " + resultSet.getString("last_name"));
            System.out.print(" | class n°: " + resultSet.getString("classe"));
            System.out.print(" | diploma date: " + resultSet.getString("date"));
            System.out.println();
        }
    }
        ;


    public static void display_in_class(Connection connection) throws SQLException {
        String request = "SELECT * FROM etudiant WHERE classe = ?";
        PreparedStatement statement = connection.prepareStatement(request);

        System.out.println("Please input the class number that you want to see");
        int class_nbr = scanner.nextInt();
        statement.setInt(1, class_nbr);
        ResultSet resultSet = statement.executeQuery();
        System.out.println("Here's all students from class n°"+class_nbr);
        while (resultSet.next()) {
            System.out.print("[id: " + resultSet.getString("id"));
            System.out.print("] prenom: " + resultSet.getString("first_name"));
            System.out.print(" | nom: " + resultSet.getString("last_name"));
            System.out.print(" | n° classe: " + resultSet.getString("classe"));
            System.out.print(" | date de diplôme: " + resultSet.getString("date"));
            System.out.println();
        }
    }


    public static void remove_student(Connection connection)throws SQLException{
        String request = "DELETE FROM etudiant WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(request);

        System.out.println("Input the ID of the student you want to remove");
        int id = scanner.nextInt();

        // voir pour rajouter un check sur l'id

        // Peut être dans une methode getbyid
        String requestID = "SELECT * FROM etudiant where id = ?";
        PreparedStatement statementID = connection.prepareStatement(requestID);
        statementID.setInt(1,id);
        ResultSet resultSetID = statementID.executeQuery();
        int id_check = -1;
        if(resultSetID.next()){
            id_check = resultSetID.getInt("id");
        // pourrait se finir avec un return id_check si c'est une fonction
        } // fin de la methode get by id
        if (id_check == id){
            statement.setInt(1, id);
            int resultSet = statement.executeUpdate();
            if (resultSet > 0) {
            System.out.println("Student with id n°" + id + " has been removed");
            }
        }else{
            System.out.println("No student with this id number !");
        }
    }
}



