package controller;

import controller.service.DatabaseService;
import lombok.AllArgsConstructor;
import model.Person;
import controller.service.FileReaderService;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class PersonController {
    private static final String CSV_REGEX = ",";
    private List<Person> model;

    public void processPerson(String personFileDir, String phoneFileDir) {
        readPersons(personFileDir);
        savePersons();
//        updatePersonAgeToDouble();
//        deleteAllUsersExceptMaxAge();
        setPhoneNumbersForPersons(readPhoneNumbers(phoneFileDir));
        savePhoneNumber();
        filterAndPrintEmptyPhoneNumbers(model);
    }

    private void savePhoneNumber() {
        DatabaseService databaseService = new DatabaseService();
        databaseService.savePhoneNumbers(filterEmptyPhoneNumbers(model));
        databaseService.closeConnection();
    }

    private List<Person> filterEmptyPhoneNumbers(List<Person> persons) {
        return persons.stream()
                .filter(person -> person.getPhoneNumber() != null)
                .collect(Collectors.toList());
    }

    private void filterAndPrintEmptyPhoneNumbers(List<Person> persons) {
        persons.stream()
                .filter(person -> person.getPhoneNumber() == null)
                .forEach(System.out::println);
//                .collect(Collectors.toList());
    }

    private void setPhoneNumbersForPersons(Map<String, String> phoneNumbersForPersons) {
        phoneNumbersForPersons.keySet()
                .forEach(name -> setPhoneNumbersForPersonByName(name, phoneNumbersForPersons.get(name)));
    }

    private void setPhoneNumbersForPersonByName(String name, String phoneNumber) {
        model.stream().filter(person -> person.getName().equals(name))
                .findFirst()
                .get()
                .setPhoneNumber(phoneNumber);
    }


    private void readPersons(String personFile) {
        List<String> personLines = FileReaderService.readFile(personFile);
        for (String line : personLines) {
            String[] splitLine = line.split(CSV_REGEX);
            model.add(new Person(splitLine[0], Integer.valueOf(splitLine[1])));
        }
    }

    private Map<String, String> readPhoneNumbers(String phoneFile) {
        Map<String, String> phoneNumbers = new HashMap<>();
        List<String> phoneLines = FileReaderService.readFile(phoneFile);
        for (String line : phoneLines) {
            String[] splitLine = line.split(CSV_REGEX);
            phoneNumbers.put(splitLine[1], splitLine[0]);
        }
        return phoneNumbers;
    }

    private void savePersons() {
        if (!model.isEmpty()) {
            DatabaseService databaseService = new DatabaseService();
            databaseService.save(model);
            databaseService.closeConnection();
        } else {
            throw new RuntimeException("No model found!");
        }
    }

    private void updatePersonAgeToDouble() {
        Person personIDWithMaxAge = getPersonIDWithMaxAge();
        DatabaseService databaseService = new DatabaseService();
        databaseService.updatePerson(personIDWithMaxAge.getId(), personIDWithMaxAge.getAge() * 2);
        databaseService.closeConnection();
    }

    private void deleteAllUsersExceptMaxAge() {
        Person personsIDSWithNotMaxAge = getPersonIDWithMaxAge();
        DatabaseService databaseService = new DatabaseService();
        databaseService.deletePerson(personsIDSWithNotMaxAge.getId());
        databaseService.closeConnection();
    }

    private Person getPersonIDWithMaxAge() {
        return model.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .orElseThrow();
    }

}
