package org.example.demos.demo2.dao;

import org.example.demos.demo2.model.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDao extends BaseDao<Person> {
    public PersonDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Person element) throws SQLException { // Va m'inserer la personne dans une base de données
        request = "INSERT INTO users (first_name,last_name) values (?,?)";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getFirstName());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()){
            element.setId(resultSet.getInt(1));
        }

        return nbRow ==1;
    }

    @Override
    public boolean update(Person element) throws SQLException{
        request = "UPDATE users set first_name = ?, last_name = ? where id = ?";
        statement = connection.prepareStatement(request);
        statement.setString(1, element.getFirstName());
        statement.setString(2, element.getLastName());
        statement.setInt(3, element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public boolean delete(Person element) throws SQLException{
        request = "DELETE from users where id = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1, element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public Person get(int id) throws SQLException {
        Person person = null;
        request = "SELECT * FROM users where id = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,id);
        resultSet = statement.executeQuery();
        if (resultSet.next()){
            person = new Person(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"));
        }
        return person;
    }

    @Override
    public List<Person> get() throws SQLException {
        List<Person> persons = new ArrayList<>();
        request = "SELECT * FROM users";
        statement = connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            Person person = new Person(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"));
            persons.add(person);
        }
        return persons;
    }
}



