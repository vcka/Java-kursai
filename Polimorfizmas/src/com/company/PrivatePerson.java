package com.company;

abstract class PrivatePerson extends Person {


    public PrivatePerson(int personalID, String name, Gender gender, EmploymentStatus employed) {
        super(personalID, name, gender, employed);
    }

    abstract void getEmploymentStatus();

    static Person of(int personalID, String name, Gender gender, EmploymentStatus employed) {
        if (employed.equals(EmploymentStatus.EMPLOYED)) {
            return new EmployedPerson(name, gender, personalID, employed);
        } else {
            return new UnemployedPerson(name, gender, personalID, employed);
        }
    }


}
