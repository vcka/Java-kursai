package controller.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.Answers;
import model.Exams;
import model.Questions;
import model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

@Data
@AllArgsConstructor
public class DatabaseService {
    private Session session;
    private SessionFactory sf;

    public DatabaseService() {
        Configuration cfg = new Configuration()
                .addAnnotatedClass(Users.class)
                .addAnnotatedClass(Exams.class)
                .addAnnotatedClass(Questions.class)
                .addAnnotatedClass(Answers.class);

        sf = cfg.buildSessionFactory();
    }

    public void beginSessionAndTransaction() {
        session = sf.openSession();
        session.beginTransaction();
    }

    public void commit() {
        session.getTransaction().commit();
    }

    public void closeConnection() {
        session.close();
    }

    public List loadUsers() {
        return session.createCriteria(Users.class).list();
    }

    public void deleteUser(Users user) {
        session.remove(user);
    }

    public void registerUser(Users user) {
        session.save(user);
    }

    public List loadExams() {
        return session.createCriteria(Exams.class).list();
    }

    public void saveExam(Exams exam){
        session.save(exam);
    }

    public List loadExamsQuestions() {
        return session.createCriteria(Questions.class).list();
    }

    public List loadQuestionsAnswers(){
        return session.createCriteria(Answers.class).list();
    }
}
