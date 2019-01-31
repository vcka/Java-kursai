package com.company;

import sun.plugin.com.JavaClass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Parameter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        HashMap<Integer, Person> people = new HashMap<>();
        Path filePeople = Paths.get("C:\\Users\\Eimantas\\GIT\\JAVA\\File uzd 1\\src\\com\\kazkas\\people.txt");
        Path filePayment = Paths.get("C:\\Users\\Eimantas\\GIT\\JAVA\\File uzd 1\\src\\com\\kazkas\\payments.txt");

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
                people.get(Integer.parseInt(nauja[2])).setReceivedMoney(people.get(Integer.parseInt(nauja[2])).getReceivedMoney() + Integer.parseInt(nauja[1]));
                ///Tas kas siuncia
                people.get(Integer.parseInt(nauja[3])).setSentMoney(people.get(Integer.parseInt(nauja[3])).getSentMoney() + Integer.parseInt(nauja[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path resultpath = Paths.get("C:\\Users\\Eimantas\\GIT\\JAVA\\File uzd 1\\src\\com\\kazkas").resolve("results");
        if(Files.exists(resultpath)){
            Files.delete(resultpath);
        }
        Files.createFile(resultpath);

        try(BufferedWriter writer = Files.newBufferedWriter(resultpath)){
            Collection<Person> collection = people.values();
            for (Person person : collection){
                writer.write(person.toString());
                writer.newLine();
            }
        }
    }
}
