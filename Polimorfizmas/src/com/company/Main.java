package com.company;

import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args) {
        PrivatePerson person = (PrivatePerson) PrivatePerson.of(1, "Jonas", Gender.MALE, EmploymentStatus.UNEMPLOYED);
        PrivatePerson person1 = (PrivatePerson) PrivatePerson.of(2, "Elze", Gender.FEMALE, EmploymentStatus.EMPLOYED);
        LegalPerson legalPerson = new LegalPerson(1, "Lukoil", EmploymentStatus.EMPLOYED);
        System.out.println(person.toString());
        System.out.println(person1.toString());
        System.out.println(legalPerson.toString());


	// write your code here
    }
}
