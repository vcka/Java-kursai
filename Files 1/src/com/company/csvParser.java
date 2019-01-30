package com.company;

import org.omg.PortableInterceptor.ServerRequestInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class csvParser {
    public static void getInfo() {
        String csvFile = "C:\\Users\\vytautasz\\Desktop\\people.txt";
        String line = "";
        String cvsSplitBy = ",";
        Map<Integer,Person> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] l = line.split(cvsSplitBy);
//                System.out.println(l[0] + l[1] + l[2]);
//                map.put(Integer.parseInt(l[0], new String[]{l[1], l[2]})

                Person person = new Person(Integer.parseInt(l[0]), l[1],l[2]);
                map.put(Integer.parseInt(l[0]), person);
                System.out.println(person.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
