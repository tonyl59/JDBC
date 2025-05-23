package org.example.Exercices.exo2.service;

import org.example.Exercices.exo2.dao.AccountDao;
import org.example.Exercices.exo2.dao.CustomerDao;
import org.example.Exercices.exo2.model.Account;
import org.example.Exercices.exo2.model.Customer;
import org.example.Exercices.exo2.utils.ConnectionUtils;

import java.sql.*;
import java.util.Scanner;

public class Bank {

    private Connection connection;
    private CustomerDao customerDao;
    private AccountDao accountDao;

    public Bank(){
        try {
            connection = new ConnectionUtils().getSQLConnection();
            customerDao = new CustomerDao(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public boolean create_customer(String firstName, String lastName, String phone) throws SQLException {
        Customer customer = new Customer(firstName,lastName,phone);
        try{
            if(customerDao.save(customer)){
                return true;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deposit(double amount){
        return false;
    }
    public boolean withdraw(double amount){
        return false;
    }
    public boolean display(){
        return false;
    }
}
