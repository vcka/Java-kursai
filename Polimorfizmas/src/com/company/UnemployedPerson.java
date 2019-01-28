package com.company;

public class UnemployedPerson extends PrivatePerson{
    public UnemployedPerson(String name, Gender gender, int personalId, EmploymentStatus employed) {

        super(personalId, name, gender, employed);
    }

    @Override
    void getEmploymentStatus() {
        super.getEmployed();
    }
}
