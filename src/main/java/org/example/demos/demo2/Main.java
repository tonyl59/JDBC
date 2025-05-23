package org.example.demos.demo2;
import org.example.demos.demo2.util.ConsoleIhm;

public class Main {
    public static void main(String[] args) {
        // Si des nouvelles fonctionnalités arrivent dans une entité... comment faire pour les adapter ? DAO.
        // DAO = Data Acess Object
        // Construction du modèle adresse... quand on attaque la DAO on a une base deja existante.
        // Par exemple si je veux passer de personne à adresse... methodes qui permettent de faire CRUD.
        // BaseDao est une base solide pour avoir un programme avec une structure propre. Les methodes qui sont dans BaseDao permettent de faire un CRUD.. pratique quand on veut travailler en equipe
        // Si au moment où on a crée une personne, on veut rajouter son adresse et ses animaux... la DAO va avoir une méthode qui crée tout.
        ConsoleIhm.start();
    }
}
