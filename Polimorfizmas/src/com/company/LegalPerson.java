package com.company;

public class LegalPerson extends Person {
    public LegalPerson(int personalID, String name, EmploymentStatus employed) {
        super(personalID, name, employed);
    }

    @Override
    public Gender getGender() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "Person{" +
                "personalID=" + getPersonalID() +
                ", name='" + getName() + '\'' +
                ", employed=" + getEmployed() +
                '}';
    }
}
