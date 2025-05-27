package org.example.Exercices.exo2.dao;

import org.example.Exercices.exo2.model.Account;
import org.example.Exercices.exo2.model.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AccountDao extends BaseDao<Account> {
    public AccountDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Account element) throws SQLException {
        return false;
    }


    @Override
    public Account get(int id) throws SQLException {
        Account account = null;
        request = "SELECT * FROM acc where id = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,id);
        resultSet = statement.executeQuery();
        if (resultSet.next()){
            account = new Account(resultSet.getInt("id"),
                    resultSet.getInt("customer_id"),
                    resultSet.getDouble("amount"));
        }
        return account;
    }

    @Override
    public List<Account> get_list(int id) throws SQLException {
        return List.of();
    }


    @Override
    public boolean deposit(Account account, double add_amount) throws SQLException {

        request = "UPDATE acc set amount = amount + ? WHERE id = ?";

        statement = connection.prepareStatement(request); // statement est deja dans base DAO
        statement.setDouble(1, add_amount);
        statement.setInt(2, account.getId());
        int nbRow = statement.executeUpdate();

        // New operation
        Operation operation = new Operation("deposit", account.getId());
        request = "INSERT INTO operation(amount, ostatus, account_id) values (?,?,?)";

        statement = connection.prepareStatement(request);
        statement.setDouble(1, add_amount);
        statement.setString(2, operation.getStatus());
        statement.setInt(3, account.getId());
        int nbRow2 = statement.executeUpdate();
        return nbRow ==1 && nbRow2 ==1;
    }

    @Override
    public boolean withdraw(Account account, double remove_amount) throws SQLException {
        request = "UPDATE acc SET amount = amount - ? WHERE id = ?";

        statement = connection.prepareStatement(request);
        statement.setDouble(1, remove_amount);
        statement.setInt(2, account.getId());
        int nbRow = statement.executeUpdate();

        // New operation
        Operation operation = new Operation("withdrawal", account.getId());
        request = "INSERT INTO operation(amount, ostatus, account_id) values (?,?,?)";
        statement = connection.prepareStatement(request);
        statement.setDouble(1, remove_amount);
        statement.setString(2, operation.getStatus());
        statement.setInt(3, account.getId());
        int nbRow2 = statement.executeUpdate();

        return nbRow ==1 && nbRow2 ==1;
    }
}


