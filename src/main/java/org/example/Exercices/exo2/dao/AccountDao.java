package org.example.Exercices.exo2.dao;

import org.example.Exercices.exo2.model.Account;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AccountDao extends BaseDao<Account> {
    public AccountDao(Connection connection) {
        super(connection);
    }
}
