package org.example.Exercices.exo2.dao;

import org.example.Exercices.exo2.model.Account;
import org.example.Exercices.exo2.model.Customer;
import org.example.Exercices.exo2.model.Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao<T> {
    protected Connection connection;
    protected PreparedStatement statement;
    protected String request;
    protected ResultSet resultSet;

    protected BaseDao(Connection connection){
        this.connection = connection;
    }


    public abstract boolean save(T element) throws SQLException;

    public abstract boolean deposit(Account account, double add_amount) throws SQLException;

    //public abstract boolean deposit(Customer customer) throws SQLException;

    //public abstract boolean withdraw(T element) throws SQLException;
    public abstract T get(int id) throws SQLException;

    public abstract List<T> get_list(int id) throws SQLException;

    public abstract boolean withdraw(Account account, double remove_amount) throws SQLException;
}
