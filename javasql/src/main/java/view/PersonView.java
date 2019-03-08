package view;

import lombok.NoArgsConstructor;
import model.Person;

import java.util.List;

@NoArgsConstructor
public class PersonView {
    public void showPersons(List<Person> persons) {
        persons.stream()
                .filter(person -> person.getPhoneNumber() == null)
                .forEach(person -> System.out.println("Person: " + person.getName() + ", id: " + person.getId() + " has no phone number."));
    }
}
