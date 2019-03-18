package controller.service;

import model.Person;
import model.PhoneNumer;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DatabaseService {

    private Session session;

    public DatabaseService() {
        Configuration cfg = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(PhoneNumer.class);

        SessionFactory sf = cfg.buildSessionFactory();

        session = sf.openSession();
    }

    public void beginTransaction() {
        session.beginTransaction();
    }

    public void commit() {
        session.getTransaction().commit();
    }

    public void closeConnection() {
        session.close();
    }

    public void save(Person person) {
        session.save(person);
    }

    public void updatePerson(Person person) {
        session.update(person);
    }

    public void deletePerson(Person personIdToDelete) {
        session.remove(personIdToDelete);
    }

    public void savePhoneNumbers(List<Person> persons) {
        for (Person person : persons) {
            savePhoneNumber(person);
        }
    }

    public void savePhoneNumber(Person person) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PHONE_NUMBER);
            preparedStatement.setString(1, person.getPhoneNumber());
            preparedStatement.setInt(2, person.getId());
            int executionResults = preparedStatement.executeUpdate();
            if (executionResults == 0) {
                throw new SQLException("Could not insert: " + person.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
