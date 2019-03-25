import modul.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(User.class).configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        User user = new User();
        user.setUserName("vcka");
        session.saveOrUpdate(user);
        session.getTransaction().commit();

        System.out.println("modul.User id: " + user.getId());

    }
}
