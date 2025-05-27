package org.example.Exercices.exo2.model;

public class Operation {

    // Attributes
    private int id;
    private double amount;
    private String status;
    private int account_id;


    // Constructor

    public Operation(int id, double amount, String status, int account_id) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }

    public Operation(String status, int account_id) {
        this.amount = 0;
        this.status = status;
        this.account_id = account_id;
    }

    // Methods

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", account_id=" + account_id +
                '}';
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
