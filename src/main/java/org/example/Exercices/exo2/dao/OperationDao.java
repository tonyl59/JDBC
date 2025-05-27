package org.example.Exercices.exo2.dao;

import org.example.Exercices.exo2.model.Account;
import org.example.Exercices.exo2.model.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperationDao extends BaseDao<Operation>{
    public OperationDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Operation element) throws SQLException {
        return false;
    }

    @Override
    public boolean deposit(Account account, double add_amount) throws SQLException {
        return false;
    }

    @Override
    public Operation get(int id) throws SQLException {
        return null;
    }


    @Override
    public List<Operation> get_list(int id) throws SQLException {
        List<Operation> operations = new ArrayList<>();
        request = "SELECT * FROM operation where account_id = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            Operation operation = new Operation(resultSet.getInt("id"),
                    resultSet.getDouble("amount"),
                    resultSet.getString("ostatus"),
                    resultSet.getInt("account_id"));
            operations.add(operation);
        }
        return operations;
    }



    @Override
    public boolean withdraw(Account account, double remove_amount) throws SQLException {
        return false;
    }
}

