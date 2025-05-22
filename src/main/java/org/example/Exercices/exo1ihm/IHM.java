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
        System.out.println("Que voulez-vous faire sur la base de donnéee etudiant ?)");
        int choix = 0;
        while (choix!=5){
            System.out.println("""
        - 1) Rajouter un étudiant
        - 2) Afficher la totalité des étudiants
        - 3) Afficher les étudiants d'une classe
        - 4) Supprimer un étudiant
        - 5) Quitter
    """);
            choix = this.scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    StudentTable.add_student(connection);
                    break;

                case 2:
                    StudentTable.display_all(connection);
                    break;
                case 3:
                    //StudentTable.display_in_class(connection);
                    break;

                case 4:
                    //StudentTable.remove_student(connection);
                    break;

                case 5:
                    System.out.println("Fin du programme, bonne journée à vous.");
                default:
                    System.out.println("Choix invalide!");


        }

    }
    }
}


