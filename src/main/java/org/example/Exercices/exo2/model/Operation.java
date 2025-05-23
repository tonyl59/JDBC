package org.example.Exercices.exo2.model;

public class Operation {

    // Attributes
    private int id;
    private double amount;
    private String status;

    // Constructor

    public Operation(int id, double amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }

    public Operation(int customer_id, String status) {
        this.amount = customer_id;
        this.status = status;
    }


    // Setters & Getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
