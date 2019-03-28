import model.*;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class);
    public static Session session;
    static DateFormat df = new SimpleDateFormat("ss.SSS");

    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Contact.class)
                .addAnnotatedClass(Branch.class);


        DOMConfigurator.configure("log4j.xml");
        logger.log(AppLogger.APPLOGGER, "Test");
        logger.debug("WARN");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
//        session.getTransaction().begin();

//        Address address = new Address("Gedo pr. 13", "Vilnius");
//
//        Employee employee = new Employee();
//
//        employee.setAddress(address);
//        employee.setName("Joris");
//
//        session.saveOrUpdate(employee);
//        session.getTransaction().commit();

        Main.findByNameLike("Gil");
        Main.findByNameLike("Gil");
        Main.findByNameLike("Gil");
//        Main.deleteAllEmployeesByIdGreaterThan(employee.getId());
//        session.getTransaction().commit();
        session.close();


    }

    static void deleteAllEmployeesByIdLessThan(long id) {
        session.getTransaction().begin();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<Employee> delete = cb.createCriteriaDelete(Employee.class);
        Root<Employee> employeeRoot = delete.from(Employee.class);
        delete.where(cb.lessThan(employeeRoot.get("id"), id));
        session.createQuery(delete).executeUpdate();
    }

    static void deleteAllEmployeesContactsByIdGreaterThan(long id) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<Contact> delete = cb.createCriteriaDelete(Contact.class);
        Root<Contact> employeeRoot = delete.from(Contact.class);
        delete.where(cb.greaterThanOrEqualTo(employeeRoot.get("id"), id));
        session.createQuery(delete).executeUpdate();
    }

    static void findByNameLike(String name) {
        session.getTransaction().begin();
        long start = System.currentTimeMillis();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> find = cb.createQuery(Employee.class);
        Root<Employee> employeeRoot = find.from(Employee.class);
        find.where(cb.like(employeeRoot.get("name"), "%"+name+"%"));
        List<Employee> employees = session.createQuery(find).getResultList();
        session.getTransaction().commit();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        employees.forEach(e -> session.evict(e));
    }

    static void deleteEmployeesByNameLike(String name) {
//        session.getTransaction().begin();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        long start = System.currentTimeMillis();
        CriteriaDelete<Employee> delete = cb.createCriteriaDelete(Employee.class);
        Root<Employee> employeeRoot = delete.from(Employee.class);
        delete.where(cb.like(employeeRoot.get("name"), "%"+name+"%"));
//        session.createQuery(delete).executeUpdate();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(session.getSessionFactory().getStatistics().getEntityFetchCount());
        System.out.println(session.getSessionFactory().getStatistics().getSecondLevelCacheHitCount());

    }
}
