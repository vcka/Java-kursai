package com.company;

public class EmployedPerson extends PrivatePerson {
    public EmployedPerson(int personalID, String name, Gender gender, EmploymentStatus employed) {
        super(personalID, name, gender, employed);
    }

    @Override
    void getEmploymentStatus() {

    }
}
