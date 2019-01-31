package com.company;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        Path filePeople = Paths.get(System.getProperty("user.dir"), "people.txt");
        Path filePayment = Paths.get(System.getProperty("user.dir"), "payments.txt");
        Map<Integer, Person> people = new HashMap<>();

        System.out.println(filePeople);
        try (BufferedReader reader = Files.newBufferedReader(filePeople)) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] nauja = line.split(", ");
                people.put(Integer.parseInt(nauja[0]), new Person(Integer.parseInt(nauja[0]), nauja[1], nauja[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = Files.newBufferedReader(filePayment)) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] nauja = line.split(", ");
                ///Gavejo ID
                people.get(Integer.parseInt(nauja[2])).setRecievedMoney(people.get(Integer.parseInt(nauja[2])).getRecievedMoney() + Integer.parseInt(nauja[1]));
                ///Tas kas siuncia
                people.get(Integer.parseInt(nauja[3])).setSentMoney(people.get(Integer.parseInt(nauja[3])).getSentMoney() + Integer.parseInt(nauja[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path resultPath = Paths.get(System.getProperty("user.dir"), "resultReceived.txt");
        Path resultPath2 = Paths.get(System.getProperty("user.dir"), "resultSent.txt");
        if (Files.exists(resultPath)) {
            Files.delete(resultPath);
        }
        if (Files.exists(resultPath2)) {
            Files.delete(resultPath2);
        }
        Files.createFile(resultPath);
        Files.createFile(resultPath2);

        try (BufferedWriter writer = Files.newBufferedWriter(resultPath)) {
            List<Person> list = new ArrayList(people.values());
            Collections.sort(list, Comparator.comparing(Person::getRecievedMoney));
            Collections.reverse(list);

            for (Person person : list) {
                writer.write(person.toString());
                writer.newLine();
            }
        }
        try (BufferedWriter writer = Files.newBufferedWriter(resultPath2)) {
            List<Person> list = new ArrayList(people.values());
//            Collections.sort(list, Comparator.comparing(Person::getSentMoney));
            Collections.sort(list, Comparator.comparing((Person person)->person.getSentMoney()));
            Collections.reverse(list);

            for (Person person : list) {
                writer.write(person.toString());
                writer.newLine();
            }
        }
    }
}

