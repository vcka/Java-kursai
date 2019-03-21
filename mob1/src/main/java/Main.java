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
import java.util.List;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class);
    public static Session session;

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
        session.getTransaction().begin();

        Address address = new Address("Gedo pr. 13","Vilnius");
        Address address1 = new Address("Liepojos 4", "Klaipeda");
        Employee employee = new Employee();
        Branch branch = new Branch();



//        Employee employee1 = new Employee();
//        Employee employee2 = new Employee();
        Contact contact = new Contact();
        Contact contact1 = new Contact();
//        Contact contact2 = new Contact();
//
        Company company = new Company();
        company.setName("MS");
        company.setAddress(address);
//
        contact.setContact_type("mobile phone");
        contact.setValue("+37068744019");
//
        contact1.setContact_type("email");
        contact1.setValue("vcka@ministras.lt");
//
//        contact2.setContact_type("mobile phone");
//        contact2.setValue("+37064867898");
//
        employee.setAddress(address);
        employee.setCompany(company);
        employee.setName("Joris");
        employee.setPosition("HR");

//        company.setBranches(new HashSet<>());
        branch.setCompany(company);
        branch.setName("Vilniaus padalinys");

        company.getBranches().add(branch);

//        employee.setContacts(new HashSet<>());
        contact.setEmployee(employee);
        employee.getContacts().add(contact);
        employee.getContacts().forEach(System.out::println);

//
//        employee1.setAddress(address1);
//        employee1.setCompany(company);
//        employee1.setName("Markas");
//        employee1.setPosition("CEO");
//
//        employee2.setAddress(address1);
//        employee2.setCompany(company);
//        employee2.setName("Karolis");
//        employee2.setPosition("DEV");
//
        contact.setEmployee(employee);

//        contact1.setEmployee(employee1);
//        contact2.setEmployee(employee2);
//        contact.setEmployee(employee);
//        company.setAddress(address1);
//
//
        session.saveOrUpdate(company);
        session.saveOrUpdate(employee);

//        session.saveOrUpdate(contact);
//        session.saveOrUpdate(contact1);
//        session.saveOrUpdate(contact2);
//        session.saveOrUpdate(employee1);
//        session.saveOrUpdate(employee2);

//        Main.deleteAllEmployeesContactsByIdGreaterThan(1);
//        Main.deleteAllEmployeesByIdGreaterThan(2);

        session.getTransaction().commit();
//        session.flush();
//        session.clear();
        Main.find("Joris");


//        CriteriaQuery<Contact> criteriaQuery = session.getCriteriaBuilder().createQuery(Contact.class);
//        criteriaQuery.from(Contact.class);
//        List<Contact> contacts = session.createQuery(criteriaQuery).getResultList();


//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
//        Root<Contact> contact = query.from(Contact.class);
//        Join<Contact, Employee> employee = contact.join("employee");
//        query.select(employee).where(cb.equal(contact.get("contact_type"), ""));

//        List<Employee> results = session.createQuery(query).getResultList();
//        results.forEach(System.out::println);

//        String hql = "FROM Employee E WHERE E.id = :employee_id";
//        Query query1 = session.createQuery(hql);
//        query1.setParameter("employee_id",1);
//        List results = query1.list();

//        session.close();

//        System.out.println(contacts);
//        results.forEach(System.out::println)

        session.close();


    }

    static void deleteAllEmployeesByIdGreaterThan(long id) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<Employee> delete = cb.createCriteriaDelete(Employee.class);
        Root<Employee> employeeRoot = delete.from(Employee.class);
        delete.where(cb.greaterThanOrEqualTo(employeeRoot.get("id"), id));
        session.createQuery(delete).executeUpdate();
    }

    static void deleteAllEmployeesContactsByIdGreaterThan(long id) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<Contact> delete = cb.createCriteriaDelete(Contact.class);
        Root<Contact> employeeRoot = delete.from(Contact.class);
        delete.where(cb.greaterThanOrEqualTo(employeeRoot.get("id"), id));
        session.createQuery(delete).executeUpdate();
    }

    static void find(String name) {
        session.getTransaction().begin();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> find = cb.createQuery(Employee.class);
        Root<Employee> companyRoot = find.from(Employee.class);
        find.where(cb.equal(companyRoot.get("name"), name));
        Employee employee = session.createQuery(find).getSingleResult();
        employee.setCompany(null);
        session.save(employee);
        session.delete(employee);
        session.getTransaction().commit();
    }
}
