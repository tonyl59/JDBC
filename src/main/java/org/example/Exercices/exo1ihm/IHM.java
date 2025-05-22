package org.example.Exercices.exo1ihm;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class IHM {
    private Scanner scanner;

    public IHM(){
        this.scanner = new Scanner(System.in);
    }

    public void start(Connection connection) throws SQLException {
        System.out.println("What do you want to do to the student database ?)");
        int choix = 0;
        while (choix!=5){
            System.out.println("""
        - 1) Add a student
        - 2) Display all students
        - 3) Display the students of a class number
        - 4) Remove a student
        - 5) Leave
    """);
            choix = this.scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1 -> StudentTable.add_student(connection);
                case 2 -> StudentTable.display_all(connection);
                case 3 -> StudentTable.display_in_class(connection);
                case 4 -> StudentTable.remove_student(connection);
                case 5 -> System.out.println("Program ending, good day to you.");
                default -> System.out.println("Invalid number !");


        }

    }
    }
}


