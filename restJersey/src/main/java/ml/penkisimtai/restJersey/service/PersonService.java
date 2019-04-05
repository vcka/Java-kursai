package ml.penkisimtai.restJersey.service;

import ml.penkisimtai.restJersey.model.Person;
import ml.penkisimtai.restJersey.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonsRepository personsRepository;

    private final List<Person> persons = new ArrayList<>();

    @PostConstruct
    public void init() {
        persons.add(new Person("Jorka", "Morka"));
        persons.add(new Person("Gazas", "Dugnas"));
        persons.add(new Person("Mantas", "Pats"));
        personsRepository.saveAll(persons);
    }
    public String sayHello(){
        return "Hello from Spring BOOT";
    }

    public Iterable<Person> getAllPersons() {
        return personsRepository.findAll();
    }

    public Person getPersonById(Long id){
        return personsRepository.findPersonById(id);
    }

    public Person getPersonByFistName (String firstName){
        return personsRepository.findPersonByFirstName(firstName);
    }

    public Person removePerson(long id){
        Person person = personsRepository.findPersonById(id);
        personsRepository.delete(person);
        return person;
    }
}
