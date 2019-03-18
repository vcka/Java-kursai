package controller;

import controller.service.DatabaseService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import model.Person;
import controller.service.FileReaderService;
import model.PhoneNumer;

import java.util.*;

@RequiredArgsConstructor
public class PersonController {

    private static final String CSV_REGEX = ",";

    @NonNull
    private List<Person> model;

    private DatabaseService databaseService = new DatabaseService();
//    private PersonView view;

    public void processPerson(String personFileDir, String phoneFileDir) {
        databaseService.beginTransaction();
        readPersons(personFileDir);
        savePersons();

        updatePersonAgeToDouble();
        deleteAllUsersExceptMaxAge();

        setPhoneNumbersForPersons(readPhoneNumbers(phoneFileDir));
//        savePhoneNumber();

//        updateView();
        databaseService.commit();
        databaseService.closeConnection();
    }

    private void readPersons(String personFile) {
        List<String> personLines = FileReaderService.readFile(personFile);
        for (String line : personLines) {
            String[] splitLine = line.split(CSV_REGEX);
            model.add(new Person(splitLine[0], Integer.valueOf(splitLine[1])));
        }
    }

    private void savePersons() {
        if (!model.isEmpty()) {
            model.forEach(databaseService::save);
        } else {
            throw new RuntimeException("No model found!");
        }
    }

    private void updatePersonAgeToDouble() {
        Person personIDWithMaxAge = getPersonIDWithMaxAge();
        personIDWithMaxAge.setAge(personIDWithMaxAge.getAge() * 2);
        databaseService.updatePerson(personIDWithMaxAge);
    }

    private Person getPersonIDWithMaxAge() {
        return model.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .orElseThrow();
    }

    private void deleteAllUsersExceptMaxAge() {
        model.remove(getPersonIDWithMaxAge());
        model.forEach(databaseService::deletePerson);
    }

//    public void updateView(){
//        PersonView view = new PersonView();
////        view.showPersons(model);
//    }

    private void savePhoneNumber() {
        DatabaseService databaseService = new DatabaseService();
        databaseService.savePhoneNumbers(filterEmptyPhoneNumbers(model));
        databaseService.closeConnection();
    }

    private List<Person> filterEmptyPhoneNumbers(List<PhoneNumer> persons) {
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




    private Map<String, String> readPhoneNumbers(String phoneFile) {
        Map<String, String> phoneNumbers = new HashMap<>();
        List<String> phoneLines = FileReaderService.readFile(phoneFile);
        for (String line : phoneLines) {
            String[] splitLine = line.split(CSV_REGEX);
            phoneNumbers.put(splitLine[1], splitLine[0]);
        }
        return phoneNumbers;
    }




//




}
