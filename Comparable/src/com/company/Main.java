package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Student student = new Student();
        Random rand = new Random();
        JavaStudentGroup group = new JavaStudentGroup();

        List<Student> students = new ArrayList<>();
        students.add(new Student("Jonas", "Varnas", rand.nextInt(50) + 1));
        students.add(new Student("Juozas", "Juozaitis", rand.nextInt(50) + 1));
        students.add(new Student("Antanas", "Antanais", rand.nextInt(50) + 1));
        students.add(new Student("John", "Doe", rand.nextInt(50) + 1));
        students.add(new Student("Zigmas", "Zigmaitis", rand.nextInt(50) + 1));
        students.add(new Student("Pranas", "Kulverstukas", rand.nextInt(50) + 1));
        students.add(new Student("Karolis", "Jevgenicius", rand.nextInt(50) + 1));
        students.add(new Student("Jadvyga", "Kastuvas", rand.nextInt(50) + 1));
        students.add(new Student("Saulius", "Palka", rand.nextInt(50) + 1));
        students.add(new Student("Dziaulius", "Malka", rand.nextInt(50) + 1));
        students.add(new Student("Egle", "Skverne", rand.nextInt(50) + 1));
        students.add(new Student("Radzis", "Radziauskas", rand.nextInt(50) + 1));
        students.add(new Student("Dalia", "Grybas", rand.nextInt(50) + 1));
        students.add(new Student("Stanislovas", "Skvernas", rand.nextInt(50) + 1));
        students.add(new Student("Briedis", "Zyle", rand.nextInt(50) + 1));
        students.add(new Student("Xavier", "Handsucker", rand.nextInt(50) + 1));
        students.add(new Student("Jonas", "Skvernas", rand.nextInt(50) + 1));
        students.add(new Student("Jonas", "Skvernas", rand.nextInt(50) + 1));
        students.add(new Student("Jonas", "Skvernas", rand.nextInt(50) + 1));
        students.add(new Student("Jonas", "Skvernas", rand.nextInt(50) + 1));
        students.add(new Student("Jonas", "Skvernas", rand.nextInt(50) + 1));
        students.add(new Student("Jonas", "Skvernas", rand.nextInt(50) + 1));

        System.out.println("Unsorted list:");
        for (Student a : students) {
            System.out.println(a);
        }
        student.compareById(students);
        student.compareBySurname(students);
        student.compareByName(students);
        group.group(students, 4);
    }
}

