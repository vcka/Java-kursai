package controller.service;

import model.Person;

import java.sql.*;
import java.util.List;

public class DatabaseService {

    public static final String DATABASE_URL = "jdbc:mysql://db4free.net:3306/vcka_java1?useSSL=false";
    public static final String DATABASE_USER = "vcka_java1";
    public static final String DABASE_PASS = "l0bzikas";
    public static final String INSERT_PERSON = "INSERT into person (name, age) values(?,?)";
    public static final String UPDATE_PERSON_ID = "UPDATE person set age=? WHERE id=?";
    public static final String DELETE_PERSON_ID = "DELETE FROM person WHERE id!=?";

    Connection connection;

    public DatabaseService() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DABASE_PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(List<Person> persons) {
        for (int i = 0; i < persons.size(); i++) {
            int personId = save(persons.get(i));
            persons.get(i).setId(personId);
        }
    }

    public int save(Person person) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERSON, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            int executionResults = preparedStatement.executeUpdate();
            if (executionResults == 0) {
                throw new SQLException("Could not insert: " + person.getName());
            }
            ResultSet generatedIds = preparedStatement.getGeneratedKeys();
            if (generatedIds.next()) {
                return generatedIds.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void updatePerson(int personIdToUpdate, int age) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PERSON_ID);
            preparedStatement.setInt(1, age);
            preparedStatement.setInt(2, personIdToUpdate);
            int executionResults = preparedStatement.executeUpdate();
            if (executionResults == 0) {
                throw new SQLException("Could not update person ID: " + personIdToUpdate);
            }
        } catch (SQLException e) {
            e.printStackTrace(); //nerupi kol kas
        }
    }

    public void deletePerson(int personIdToDelete) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PERSON_ID);
            preparedStatement.setInt(1, personIdToDelete);
            int executionResults = preparedStatement.executeUpdate();
            if (executionResults == 0) {
                throw new SQLException("Could not delete person ID: " + personIdToDelete);
            }
        } catch (SQLException e) {
            e.printStackTrace(); //nerupi kol kas

        }
    }
}
