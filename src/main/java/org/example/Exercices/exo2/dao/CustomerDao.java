package org.example.Exercices.exo2.dao;

import org.example.Exercices.exo2.model.Account;
import org.example.Exercices.exo2.model.Customer;

import java.sql.*;
import java.util.List;

public class CustomerDao extends BaseDao<Customer>{
    public CustomerDao(Connection connection) {super(connection);}

    @Override
    public boolean save(Customer customer) throws SQLException {
        request = "INSERT INTO customer (last_name,first_name,phone) values (?,?,?)";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS); // statement est deja dans base DAO
        statement.setString(1,customer.getLastName());
        statement.setString(2,customer.getFirstName());
        statement.setString(3,customer.getPhone());

        int rowNb = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys(); // Pareil il est deja declaré dans base dao aussi

        int rowNb2 = 0;
        if (resultSet.next()){
            customer.setId(resultSet.getInt(1));
            System.out.println(rowNb+" line added for customer");

            Account account = new Account(customer.getId(), customer);
            request = "INSERT INTO acc (customer_id) values (?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,customer.getId());

            rowNb2 = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                account.setId(resultSet.getInt(1));
                System.out.println(rowNb+" line added for customer's account");
            }

        }
        return rowNb == 1 && rowNb2 == 1; //rowNB our le client et nbrRow2 pour le compte
    }

    @Override
    public boolean deposit(Customer customer) throws SQLException {
        return false;
    }

    @Override
    public boolean withdraw(Customer customer) throws SQLException {
        return false;
    }

    @Override
    public Customer get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Customer> get() throws SQLException {
        return List.of();
    }
}



