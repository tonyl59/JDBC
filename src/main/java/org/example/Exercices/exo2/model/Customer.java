package org.example.Exercices.exo2.model;

public class Customer {

    // Attributes
    private int id;
    private int customer_id;

    // Constructor

    public Customer(int id, int customer_id) {
        this.id = id;
        this.customer_id = customer_id;
    }

    public Customer(int customer_id) {
        this.customer_id = customer_id;
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
}
