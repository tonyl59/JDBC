package org.example.Exercices.exo2.service;

import org.example.Exercices.exo2.dao.AccountDao;
import org.example.Exercices.exo2.dao.CustomerDao;
import org.example.Exercices.exo2.dao.OperationDao;
import org.example.Exercices.exo2.model.Account;
import org.example.Exercices.exo2.model.Customer;
import org.example.Exercices.exo2.model.Operation;
import org.example.Exercices.exo2.utils.ConnectionUtils;

import java.sql.*;
import java.util.List;

public class Bank {
    // Attributes
    private Connection connection;
    private CustomerDao customerDao;
    private AccountDao accountDao;
    private OperationDao operationDao;

    // Constructor
    public Bank(){
        try {
            connection = new ConnectionUtils().getSQLConnection();
            customerDao = new CustomerDao(connection);
            accountDao = new AccountDao(connection);
            operationDao = new OperationDao(connection);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Methods
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



    public boolean deposit(Account account, double money) {
        try {
            if(accountDao.deposit(account, money)){
                return true;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public boolean withdraw(Account account, double money){
        try {
            if(accountDao.withdraw(account, money)){
                return true;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }




    public boolean display(){
        return false;
    }



    // Get objects methods


    public Account getAccount(int id){ // For deposit & withdraw
        try{
            return accountDao.get(id);
        }catch(SQLException e){
            throw new RuntimeException();
        }
    }
    public Customer getCustomer(int id){
        try{
            return customerDao.get(id);
        }catch(SQLException e){
            throw new RuntimeException();
        }
    }

    public List<Operation> getOperationsByAccId(int id){
        try{
            return operationDao.get_list(id);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*public Operation getOperation(int id){
        try{
            return operationDao.get(id);
        }catch(SQLException e){
            throw new RuntimeException();
        }
    }*/


}
