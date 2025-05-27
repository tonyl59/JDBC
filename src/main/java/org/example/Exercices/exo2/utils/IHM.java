package org.example.Exercices.exo2.utils;

import org.example.Exercices.exo2.model.Account;
import org.example.Exercices.exo2.model.Customer;
import org.example.Exercices.exo2.model.Operation;
import org.example.Exercices.exo2.service.Bank;

import java.sql.SQLException;
import java.util.List;
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
        System.out.println("On which customer's account ID do you want to deposit ? ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Account account = bank.getAccount(id);
        if (account == null){
            System.out.println("Account ID not found!");
            return;
        }

        System.out.println("Please input how much € you want to deposit");
        double money = scanner.nextDouble();
        scanner.nextLine();
        while(money<0){
            System.out.println("Please input a positive amount");
            scanner.nextLine();
        }

        account.setAmount(account.getAmount()+money);

        bank.deposit(account, money);

        System.out.printf("\nDeposit of %s€ on ID %s done", money, id);

    }
    private static void withdrawAction() throws SQLException{
        System.out.println("On which customer's account ID do you want to withdraw ? ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Account account = bank.getAccount(id);
        if (account == null){
            System.out.println("Account ID not found!");
            return;
        }

        if (account.getAmount() == 0){
            System.out.println("You cannot withdraw from an empty account !");
            return;
        }

        double money = 0;
        System.out.println("Please input how much € you want to withdraw");
        boolean is_positive = false;
        while (!is_positive){
            money = scanner.nextDouble();
            scanner.nextLine();
            if (money<0){
                System.out.println("Please input a positive value");
            }else if(account.getAmount() - money < 0){
                System.out.println("You cannot withdraw more than what you have in your account!");
                System.out.printf("\nPlease input a value equal or lower than your amount (%s €) in this account\n",account.getAmount());
            }else if(money>0 && account.getAmount()-money>0 || money ==0){
                is_positive = true;
            }


        }
        bank.withdraw(account, money);
        System.out.printf("\nWithdrawal of %s€ on ID %s done", money, id);
    }

    private static void displayAction() throws SQLException{
        System.out.println("Which account ID do you want its informations displayed? ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Account account = bank.getAccount(id);
        Customer customer = bank.getCustomer(account.getCustomer_id());
        System.out.println(account);
        System.out.println(customer);

        List<Operation> operations =  bank.getOperationsByAccId(id); // On peut utiliser la technique de cette methode pour display tout les comptes en utilisant l'objet Account à la place
        for (Operation operation : operations){
            System.out.println(operation);
        };


    }

}
