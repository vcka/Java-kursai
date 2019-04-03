import com.mysema.commons.lang.CloseableIterator;
import com.mysema.query.hql.HQLQuery;
import com.mysema.query.hql.hibernate.HibernateQuery;
import com.mysema.query.hql.hibernate.sql.HibernateSQLQuery;
import com.mysema.query.hql.jpa.JPAQuery;
import com.mysema.query.sql.DerbyTemplates;
import com.mysema.query.sql.SQLTemplates;
import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {

    private static Session session;
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Exam.class)
                .addAnnotatedClass(Question.class)
                .addAnnotatedClass(Answer.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserAnswer.class);

        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        session.getTransaction().begin();


//        HibernateQuery query = new HibernateQuery(session);

        QExam qExam = new QExam("Belenkas");
        HQLQuery query = new HibernateQuery (session);

        List<Exam> matematika = query.from(qExam)
                .where(qExam.name.eq("Matematika"))
                .list(qExam);
        System.out.println(matematika);

        List<Exam> list = query.from(qExam).list(qExam);

        System.out.println(list);


//        User user = new User();
//        user.setUserName("vcka");
//        user.setEmail("vcka@ministras.lt");
//        user.setPassword("l0pas");
//
//        UserAnswer userAnswer = new UserAnswer();
//        user.addUserAnswer(userAnswer);
//
//        Exam exam = new Exam();
//        exam.setName("Matematika");
//
//        Question question1 = new Question();
//        question1.setQuestion("Klausimas 1");
//        Question question2 = new Question();
//        question2.setQuestion("Klausimas 2");
//
//        exam.addQuestion(question1);
//        exam.addQuestion(question2);
//
//        Answer answer1 = new Answer();
//        answer1.setAnswer("Atsakymas 1");
//        Answer answer2 = new Answer();
//        answer2.setAnswer("Atsakymas 2");
//        Answer answer3 = new Answer();
//        answer3.setAnswer("Atsakymas 3");
//        Answer answer4 = new Answer();
//        answer4.setAnswer("Atsakymas 4");
//        Answer answer5 = new Answer();
//        answer5.setAnswer("Atsakymas 5");
//        Answer answer6 = new Answer();
//        answer6.setAnswer("Atsakymas 6");
//
//        question1.addAnswer(answer1);
//        question1.addAnswer(answer2);
//        question1.addAnswer(answer3);
//        question2.addAnswer(answer4);
//        question2.addAnswer(answer5);
//        question2.addAnswer(answer6);
//        question1.addRightAnswer(answer1);
//        session.saveOrUpdate(exam);
////        session.flush();
//        userAnswer.setAnswer(answer1);
//        session.saveOrUpdate(user);
////        session.saveOrUpdate(userAnswer);
//
//        session.getTransaction().commit();
//
//        session.getTransaction().begin();
//        System.out.println("Delete question1: " + question1.getQuestion());
//        exam.removeQuestion(question2);
//        question1.removeAnswer(answer2);
////        session.delete(question2);
////        session.saveOrUpdate(question1);
////        session.flush();
//        session.getTransaction().commit();
////        Delete all
//
////        session.getTransaction().begin();
////        System.out.println("Deleting exam" + exam.getName());
////        session.delete(exam);
////        session.getTransaction().commit();
////
//
////        Update answer question
//        session.getTransaction().begin();
//        Answer answer7 = new Answer();
//
//        answer1.setAnswer("Naujas atsakymas");
//        System.out.println("Klausimo pakeitimas");
////        session.saveOrUpdate(answer1);
////        session.flush();
////        userAnswer.setAnswer(answer3);
//        session.remove(user);
////        session.saveOrUpdate(user);
//        session.getTransaction().commit();
//
//
//
////        session.getTransaction().begin();
////        session.flush();
////        question1.setExam(exam);
////        question1.addAnswer(answer7);
////        session.saveOrUpdate(question1);
////        session.getTransaction().commit();
////        System.out.println(user.getUserAnswers());
//        userAnswer.getUser();
//
//        System.out.println(user.getUserAnswers().contains(question2.getRight_answer()));
//        System.out.println(question1.getExam());
//        session.close();
    }

    public static Exam addExam(String name){
        Exam exam = new Exam();
        exam.setName(name);
        session.saveOrUpdate(exam);
        return exam;
    }

    public static void removeExam(Exam exam){
//        exam.
    }
}
