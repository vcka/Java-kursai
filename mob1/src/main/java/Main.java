import model.Address;
import model.Company;
import model.Contact;
import model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.Constraint;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Contact.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

//        Address address = new Address("Gedo pr. 13","Vilnius");
//        Address address1 = new Address("Liepojos 4", "Klaipeda");
//        Employee employee = new Employee();
//        Employee employee1 = new Employee();
//        Employee employee2 = new Employee();
//        Contact contact = new Contact();
//        Contact contact1 = new Contact();
//        Contact contact2 = new Contact();
//
//        Company company = new Company();
//        company.setName("MS");
//        company.setAddress(address);
//
//        contact.setContact_type("mobile phone");
//        contact.setValue("+37068744019");
//
//        contact1.setContact_type("email");
//        contact1.setValue("vcka@ministras.lt");
//
//        contact2.setContact_type("mobile phone");
//        contact2.setValue("+37064867898");
//
//        employee.setAddress(address);
//        employee.setCompany(company);
//        employee.setName("Joris");
//        employee.setPosition("HR");
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
//        contact.setEmployee(employee);
//        contact1.setEmployee(employee1);
//        contact2.setEmployee(employee2);
//        contact.setEmployee(employee);
//        company.setAddress(address1);
//
//
//        session.saveOrUpdate(company);
//        session.saveOrUpdate(employee);
//        session.saveOrUpdate(contact);
//        session.saveOrUpdate(contact1);
//        session.saveOrUpdate(contact2);
//        session.saveOrUpdate(employee1);
//        session.saveOrUpdate(employee2);
//
//        session.getTransaction().commit();

        CriteriaQuery<Contact> criteriaQuery = session.getCriteriaBuilder().createQuery(Contact.class);
        criteriaQuery.from(Contact.class);
        List<Contact> contacts = session.createQuery(criteriaQuery).getResultList();


        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Contact.class)
                .createAlias("joinObject", "joinObject")
                .add(Restrictions.not(Restrictions.like("name", "string1", MatchMode.END)))
                .add(Restrictions.not(Restrictions.like("name", "string2", MatchMode.END)))
                .add(Restrictions.in("joinObject.id", ids));




        session.close();

        System.out.println(contacts);
        session.close();

    }
}
