package com.company;

abstract class Person {
    private int personalID;
    private String name;
    private Gender gender;
    private EmploymentStatus employed;

    public Person(int personalID, String name, Gender gender, EmploymentStatus employed) {
        this.personalID = personalID;
        this.name = name;
        this.gender = gender;
        this.employed = employed;
    }

    public EmploymentStatus getEmployed() {
        return employed;
    }

    public int getPersonalID() {
        return personalID;
    }

    public void setPersonalID(int personalID) {
        this.personalID = personalID;
    }

        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

}
