package com.company;

public class LegalPerson extends Person {
    public LegalPerson(int personalID, String name, Gender gender, EmploymentStatus employed) {
        super(personalID, name, gender, employed);
    }

    @Override
    public Gender getGender() {
        throw new UnsupportedOperationException();
    }
}
