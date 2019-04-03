package controller.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Data
@RequiredArgsConstructor
public class DatabaseService {
    private Session session;
    private SessionFactory sf = DatabaseUtil.getSessionFactory();

//    public DatabaseService() {
//        Configuration cfg = new Configuration()
//                .addAnnotatedClass(Users.class)
//                .addAnnotatedClass(Exams.class)
//                .addAnnotatedClass(Questions.class)
//                .addAnnotatedClass(Answers.class)
//                .addAnnotatedClass(WrightAnswers.class)
//                .addAnnotatedClass(UserAnswers.class);
//
//        sf = cfg.buildSessionFactory();
//    }

    public void beginSessionAndTransaction() {
//        session = sf.getCurrentSession();
        session = sf.openSession();
        session.beginTransaction();
    }

    public void commit() {
        session.getTransaction().commit();
    }

    public void closeConnection() {
        session.close();
    }

    public List<Users> loadUsers() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = builder.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);
        query.select(root);
        Query<Users> q = session.createQuery(query);
        return q.getResultList();
//        return session.createCriteria(Users.class).list();
    }

    public void deleteUser(Users user) {
        session.remove(user);
    }

    public void registerUser(Users user) {
        session.save(user);
    }

    public List<Exams> loadExams() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Exams> query = builder.createQuery(Exams.class);
        Root<Exams> root = query.from(Exams.class);
        query.select(root);
        Query<Exams> q = session.createQuery(query);
        return q.getResultList();
//        return session.createCriteria(Exams.class).list();
    }

    public void saveExam(Exams exam) {
        session.save(exam);
    }

    public List<Questions> loadExamsQuestions() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Questions> query = builder.createQuery(Questions.class);
        Root<Questions> root = query.from(Questions.class);
        query.select(root);
        Query<Questions> q = session.createQuery(query);
        return q.getResultList();
//        return session.createCriteria(Questions.class).list();
    }

    public List<Answers> loadQuestionsAnswers() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Answers> query = builder.createQuery(Answers.class);
        Root<Answers> root = query.from(Answers.class);
        query.select(root);
        Query<Answers> q = session.createQuery(query);
        return q.getResultList();
//        return session.createCriteria(Answers.class).list();
    }

    public List<WrightAnswers> loadWrightAnswers() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<WrightAnswers> query = builder.createQuery(WrightAnswers.class);
        Root<WrightAnswers> root = query.from(WrightAnswers.class);
        query.select(root);
        Query<WrightAnswers> q = session.createQuery(query);
        return q.getResultList();
//        return session.createCriteria(Answers.class).list();
    }

    public void saveWrightAnswers(WrightAnswers wrightAnswers) {
        session.save(wrightAnswers);
    }

    public List<UserAnswers> loadUsersAnswers() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserAnswers> query = builder.createQuery(UserAnswers.class);
        Root<UserAnswers> root = query.from(UserAnswers.class);
        query.select(root);
        Query<UserAnswers> q = session.createQuery(query);
        return q.getResultList();
//        return session.createCriteria(Answers.class).list();
    }

    public UserAnswers saveUsersAnswers(UserAnswers usersAnswers) {
        return  (UserAnswers) session.merge(usersAnswers);
    }

    public Questions saveQuestion(Questions questions){
        return  (Questions) session.merge(questions);
    }
}
