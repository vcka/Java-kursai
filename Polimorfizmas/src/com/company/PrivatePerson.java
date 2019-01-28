package com.company;

abstract class PrivatePerson extends Person {


    public PrivatePerson(int personalID, String name, Gender gender, EmploymentStatus employed) {
        super(personalID, name, gender, employed);
    }

    abstract void getEmploymentStatus();

    static Person of(int personalID, String name, Gender gender, EmploymentStatus employed) {
        if (employed.equals("EMPLOYED")) {
            return new EmployedPerson(personalID, name, gender, employed);
        } else {
            return new UnemployedPerson(name, gender, personalID, employed);
        }
    }


}
