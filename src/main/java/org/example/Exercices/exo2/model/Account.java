package org.example.Exercices.exo2.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account {

    // Attributes
    private int id;
    private int customer_id;
    //private Customer customer;
    private static List<Operation> operations = new ArrayList<>();
    private double amount;


    // Constructor

    /*public Account(int id, int customer_id, Customer customer) {
        this.id = id;
        this.customer_id = customer_id;
        this.customer = customer;//TODO voir comment je met customer, operations et amount à null/à par defaut sur SQL
        this.amount = 0;

    }

    public Account(int customer_id, Customer customer) {
        this.customer_id = customer_id;
        this.customer = customer;
        this.operations = new ArrayList<Operation>();
        this.amount = 0;
    } */
    public Account(int customer_id) {
        this.customer_id = customer_id;
        this.amount = 0;
    }

    public Account(int id, int customer_id, double amount) {
        this.id = id;
        this.customer_id = customer_id;
        this.amount = amount;
    }

    // Methods

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", amount=" + amount +
                "€}";
    }


    // Setters & Getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static List<Operation> getOperations() {
        return operations;
    }

    public static void setOperations(List<Operation> operations) {
        Account.operations = operations;
    }
}
