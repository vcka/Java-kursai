import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.Person;
import model.Salary;
import org.bson.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import util.MongoDBUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {
    private static Session session;
    private static SessionFactory sessionFactory;
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Salary.class);


        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        session.getTransaction().begin();
//
//        MongoClient mongoClient = MongoDBUtil.createMongoClient();
//        MongoDatabase database = mongoClient.getDatabase("vckaDB");
//        MongoCollection<Document> collection = database.getCollection("firstCollection");
//
//        Document person = new Document("name", "VckA")
//                .append("skill", "non-MongoDB");
//        collection.insertOne(person);
        findAllPersons().forEach(Main::savePersonsToMongoDB);
        session.close();
    }

    static List<Person> findAllPersons() {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Person> find = cb.createQuery(Person.class);
        Root<Person> employeeRoot = find.from(Person.class);
        find.where(cb.like(employeeRoot.get("name"), "%"));
        return session.createQuery(find).getResultList();
    }

    static void savePersonsToMongoDB(Person p){
        MongoClient mongoClient = MongoDBUtil.createMongoClient();
        MongoDatabase database = mongoClient.getDatabase("vckaDB");
        MongoCollection<Document> collection = database.getCollection("firstCollection");
        Document person = new Document("id", p.getId())
                .append("name", p.getName())
                .append("age", p.getAge())
                .append("salary", p.getSalary().getPay());
        collection.insertOne(person);
    }
}
