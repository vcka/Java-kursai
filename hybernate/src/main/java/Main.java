
import model.Person;
import model.Salary;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        Session session = em.unwrap(Session.class);
        em.getTransaction().begin();

        Person person = new Person("Vytautas", 39);
        session.save(person);

        Salary salary = new Salary(2000);
        salary.setId(person.getId());
        person.setSalary(salary);
        session.save(person);

        em.getTransaction().commit();

        Salary foundSalary = session.find(Salary.class, 18L);
        System.out.println(foundSalary);
        em.close();
    }
}
