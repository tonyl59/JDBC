package org.example.Exercices.exo2.utils;

import org.example.Exercices.exo2.model.Customer;
import org.example.Exercices.exo2.service.Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// Va faire tout les prints et partie utilisateur....
// Mais que se passe t-il si j'ai une erreur (requete sql) ... => Il faut aller à la DAO
public class IHM {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void start() throws SQLException {
        int input = -1;
        while (input!=0) {
            System.out.println("\n==== Welcome to the bank account manager====");
            System.out.println("1. Create a customer and its associated bank account");
            System.out.println("2. Deposit on existing account");
            System.out.println("3. Withdraw from an existing account");
            System.out.println("4. Display account");
            System.out.println("0. Leave program");

            System.out.print("Your choice : ");
            input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1 -> addCustomerAction();
                case 2 -> depositAction();
                case 3 -> withdrawAction();
                case 4 -> displayAction();
                case 0 -> System.out.println("Program shutting down, have a good day!");
                default -> System.out.println("Invalid input");
            }
        }
    }

    private static void addCustomerAction() throws SQLException {
        System.out.println("Please input customer's last name");
        String lastName = scanner.nextLine();
        System.out.println("Please input customer's first name");
        String firstName = scanner.nextLine();
        System.out.println("Please input customer's phone number (with XX XX XX XX XX format)");
        String phone = scanner.nextLine();

        bank.create_customer(lastName, firstName, phone);
        System.out.printf("\nCustomer added as well as their bank account : %s %s, %s", lastName, firstName, phone);
    }

    private static void depositAction() throws SQLException{ //TODO Deposit, withdraw & display pas encore pret, il faut aussi faire l'operationDao
        System.out.println("Please input how much € you want to deposit");
        double money = scanner.nextDouble();
        scanner.nextLine();
        bank.deposit(money);

    }
    private static void withdrawAction() throws SQLException{
        System.out.println("Please input how much € you want to withdraw");
        double money = scanner.nextDouble();
        scanner.nextLine();
        bank.withdraw(money);
    }

    private static void displayAction() throws SQLException{
        /*String request = "SELECT * FROM etudiant";
        Connection connection;
        PreparedStatement statement = connection.prepareStatement(request);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            System.out.print("id: "+ resultSet.getInt("id"));
            System.out.print("] last name: " + resultSet.getString("last_name"));
            System.out.print(" | first name: " + resultSet.getString("first_name"));
            System.out.print(" | phone number " + resultSet.getString("phone"));
            System.out.println();
        } */
    }

}
