package controller;

import controller.service.DatabaseService;
import lombok.AllArgsConstructor;
import model.Person;
import controller.service.FileReaderService;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class PersonController {
    private static final String CSV_REGEX = ",";
    private List<Person> model;

    public void processPerson(String personFileDir){
        readPersons(personFileDir);
        savePersons();
        updatePersonAgeToDouble();
        deleteAllUsersExeptMaxAge();
    }


    private void readPersons(String personFile) {
        List<String> personLines = FileReaderService.readFile(personFile);
        for (String line : personLines) {
            String[] splitLine = line.split(CSV_REGEX);
            model.add(new Person(splitLine[0], Integer.valueOf(splitLine[1])));
        }
    }
    private void savePersons(){
        if (!model.isEmpty()) {
            DatabaseService databaseService = new DatabaseService();
            databaseService.save(model);
            databaseService.closeConnection();
        }else {
            throw new RuntimeException("No model found!");
        }
    }

    private void updatePersonAgeToDouble(){
        Person personIDWithMaxAge = getPersonIDWithMaxAge();
        DatabaseService databaseService = new DatabaseService();
        databaseService.updatePerson(personIDWithMaxAge.getId(), personIDWithMaxAge.getAge()*2);
        databaseService.closeConnection();
    }

    private Person getPersonIDWithMaxAge() {
        return model.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .orElseThrow();
    }

    private void deleteAllUsersExeptMaxAge(){
        Person personIDWithMaxAge = getPersonIDWithMaxAge();
        DatabaseService databaseService = new DatabaseService();
        databaseService.deletePerson(getPersonIDWithMaxAge().getId());
        databaseService.closeConnection();
    }
}
