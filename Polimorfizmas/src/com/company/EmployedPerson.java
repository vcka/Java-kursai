package com.company;

public class EmployedPerson extends PrivatePerson {
    public EmployedPerson(String name, Gender gender, int personalId, EmploymentStatus employed) {
        super(personalId, name, gender, employed);
    }

    @Override
    void getEmploymentStatus() {
        super.getEmployed();
    }
}
