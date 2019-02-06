package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {
        Student student = new Student();
        Random rand = new Random();
        JavaStudentGroup group = new JavaStudentGroup();

        List<Student> students = new ArrayList<>();
        students.add(new Student("Jonas", "Varnas", rand.nextInt(50) + 1 ));
        students.add(new Student("Juozas", "Juozaitis", rand.nextInt(50) + 1));
        students.add(new Student("Antanas", "Antanais", rand.nextInt(50) + 1 ));
        students.add(new Student("John", "Doe", rand.nextInt(50) + 1 ));
        students.add(new Student("Zigmas", "Zigmaitis", rand.nextInt(50) + 1 ));
        students.add(new Student("Pranas", "Kulverstukas", rand.nextInt(50) + 1 ));
        students.add(new Student("Karolis", "Jevgenicius", rand.nextInt(50) + 1 ));
        students.add(new Student("Jadvyga", "Kastuvas", rand.nextInt(50) + 1 ));
        students.add(new Student("Saulius", "Palka", rand.nextInt(50) + 1 ));
        students.add(new Student("Dziaulius", "Malka", rand.nextInt(50) + 1 ));
        students.add(new Student("Egle", "Skverne", rand.nextInt(50) + 1 ));
        students.add(new Student("Radzis", "Radziauskas", rand.nextInt(50) + 1 ));
        students.add(new Student("Dalia", "Grybas", rand.nextInt(50) + 1 ));
        students.add(new Student("Stanislovas", "Skvernas", rand.nextInt(50) + 1 ));
        students.add(new Student("Briedis", "Zyle", rand.nextInt(50) + 1 ));
        students.add(new Student("Xavier", "Handsucker", rand.nextInt(50) + 1 ));
        students.add(new Student("Jonas", "Skvernas", rand.nextInt(50) + 1 ));
        students.add(new Student("Jonas", "Skvernas", rand.nextInt(50) + 1 ));
        students.add(new Student("Jonas", "Skvernas", rand.nextInt(50) + 1 ));
        students.add(new Student("Jonas", "Skvernas", rand.nextInt(50) + 1 ));
        students.add(new Student("Jonas", "Skvernas", rand.nextInt(50) + 1 ));
        students.add(new Student("Jonas", "Skvernas", rand.nextInt(50) + 1 ));

        System.out.println("Unsorted list:");
        for (Student a : students) {
            System.out.println(a);
        }
        student.compareById(students);
        student.compareBySurname(students);
        student.compareByName(students);
        group.group(students, 7);
//        final AtomicInteger counter = new AtomicInteger(0);
//        final int size = 1;
//
//        final Collection<List<Student>> partitioned = students.stream()
//                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / size))
//                .values();
//
//        partitioned.forEach(System.out::println);


//        groups(students,4);
//        int size = (int) Math.ceil(students.size() / 3.0);
//        for (int start = 0; start < students.size(); start += size) {
//            int end = Math.min(start + size, students.size());
//            List<Student> sublist = students.subList(start, end);
//            System.out.println(sublist);
//        }
    }




}

