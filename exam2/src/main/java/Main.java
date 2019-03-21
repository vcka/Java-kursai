import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Exam.class)
                .addAnnotatedClass(Question.class)
                .addAnnotatedClass(Answer.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserAnswer.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Exam exam = new Exam();
        Question question = new Question();
        Question question1 = new Question();
        Answer answer = new Answer();
        Answer answer1 = new Answer();
        Answer answer2 = new Answer();

        Answer answer3 = new Answer();
        Answer answer4 = new Answer();
        Answer answer5 = new Answer();
        UserAnswer userAnswer = new UserAnswer();


        User user = new User("vcka", "vcka@ministras.lt", "l0pas", false);

        exam.setName("Matematika");

        question.setExam(exam);
        question.setQuestion("Kiek bus 2*2?");
        answer.setAnswer("2");
        answer1.setAnswer("0");
        answer2.setAnswer("4");

        List<Answer> answers = Arrays.asList(answer, answer1, answer2);
        answers.forEach(an -> an.setQuestion(question));
        question.setWrightAnswer(answer);
        answers.forEach(ans -> Main.saveOrUpdate(ans, session));



        question1.setExam(exam);
        question1.setQuestion("Kas tu toks?");
        answer3.setAnswer("Niekas");
        answer4.setAnswer("Viskas");
        answer5.setAnswer("Belekas");

        List<Answer> answers2 = Arrays.asList(answer3, answer4, answer5);
        answers2.forEach(an -> an.setQuestion(question));
        question1.setWrightAnswer(answer5);
        session.saveOrUpdate(question1);
        answers2.forEach(ans -> Main.saveOrUpdate(ans, session));


        userAnswer.setUser(user);
        userAnswer.setAnswer(answer1);


        session.save(user);
        session.save(userAnswer);
        session.getTransaction().commit();

//        System.out.println(question.getWrightAnswer());



        session.getTransaction().begin();
        question.setWrightAnswer(answer1);
        question1.setWrightAnswer(answer4);
        answers.forEach(ans -> Main.saveOrUpdate(ans, session));
        answers2.forEach(ans -> Main.saveOrUpdate(ans, session));
//        System.out.println(question.getWrightAnswer());




        session.getTransaction().commit();
        session.close();
        System.out.println("Wright answer: " + question.getWrightAnswer());
        System.out.println("User answer: " + userAnswer.getAnswer());
    }

    static void saveOrUpdate(Answer answer, Session session) {
        session.saveOrUpdate(answer);
    }
}
