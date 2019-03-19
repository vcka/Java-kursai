package controller.service;

import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseUtil {
    private static SessionFactory sessionFactory;

    static {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Users.class)
                .addAnnotatedClass(Exams.class)
                .addAnnotatedClass(Questions.class)
                .addAnnotatedClass(Answers.class)
                .addAnnotatedClass(WrightAnswers.class)
                .addAnnotatedClass(UserAnswers.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
