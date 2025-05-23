package org.example.demos.demo2.service;

import org.example.demos.demo2.dao.PersonDao;
import org.example.demos.demo2.model.Person;
import org.example.demos.demo2.util.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PersonService {

    private PersonDao personDao;
    private Connection connection;

    public PersonService() {
        try {
            connection = new DatabaseManager().getConnection();
            personDao = new PersonDao(connection);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }



    public boolean createPerson(String firstName, String lastName){
        Person person = new Person(firstName, lastName);
        try{
            if(personDao.save(person)){
                return true;
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean updatePerson(Person person){
        try{
            if(personDao.update(person)){
                return true;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Person getPerson(int id){
        try{
            return personDao.get(id);
        }catch(SQLException e){
            throw new RuntimeException();
        }
    }

    public boolean deletePerson(int id){
        Person person = null;
        try{
            person = personDao.get(id);
            if(person!=null){
                return personDao.delete(person);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Person> getAllPerson(){
        try {
            return personDao.get();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
