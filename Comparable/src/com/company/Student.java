package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student {
    private String name;
    private String surName;
    private int id;

    public Student() {
    }

    public Student(String name, String surName, int id) {
        this.name = name;
        this.surName = surName;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getId() {
        return id;
    }

    public void compareByName(List<Student> students) {
        Collections.sort(students, Comparator.comparing(Student::getName));
        System.out.println("Sorted by first name:");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void compareBySurname(List<Student> students) {
        Collections.sort(students, Comparator.comparing(Student::getSurName));
        System.out.println("Sorted by last name:");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void compareById(List<Student> students) {
        Collections.sort(students, Comparator.comparing(Student::getId));
        System.out.println("Sorted by id:");
        for (Student s : students) {
            System.out.println(s);
        }

    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", id=" + id +
                '}';
    }
}
