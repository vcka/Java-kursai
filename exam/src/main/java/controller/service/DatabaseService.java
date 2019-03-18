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
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = builder.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);
        query.select(root);
        Query<Users> q=session.createQuery(query);
        List<Users> users=q.getResultList();
        return users;
//        return session.createCriteria(Users.class).list();
    }

    public void deleteUser(Users user) {
        session.remove(user);
    }

    public void registerUser(Users user) {
        session.save(user);
    }

    public List loadExams() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Exams> query = builder.createQuery(Exams.class);
        Root<Exams> root = query.from(Exams.class);
        query.select(root);
        Query<Exams> q=session.createQuery(query);
        List<Exams> exams=q.getResultList();
        return exams;
//        return session.createCriteria(Exams.class).list();
    }

    public void saveExam(Exams exam){
        session.save(exam);
    }

    public List loadExamsQuestions() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Questions> query = builder.createQuery(Questions.class);
        Root<Questions> root = query.from(Questions.class);
        query.select(root);
        Query<Questions> q=session.createQuery(query);
        List<Questions> questions=q.getResultList();
        return questions;
//        return session.createCriteria(Questions.class).list();
    }

    public List loadQuestionsAnswers(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Answers> query = builder.createQuery(Answers.class);
        Root<Answers> root = query.from(Answers.class);
        query.select(root);
        Query<Answers> q=session.createQuery(query);
        List<Answers> answers=q.getResultList();
        return answers;
//        return session.createCriteria(Answers.class).list();
    }
}
