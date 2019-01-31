package com.company;

import java.util.Comparator;

public class Person {
    private int id;
    private String name;
    private String pavarde;
    private int recievedMoney;
    private int sentMoney;

    public int getRecievedMoney() {
        return recievedMoney;
    }

    public void setRecievedMoney(int recievedMoney) {
        this.recievedMoney = recievedMoney;
    }

    public int getSentMoney() {
        return sentMoney;
    }

    public void setSentMoney(int sentMoney) {
        this.sentMoney = sentMoney;
    }

    public Person(int id, String name, String pavarde) {
        this.id = id;
        this.name = name;
        this.pavarde = pavarde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", recievedMoney=" + recievedMoney +
                ", sentMoney=" + sentMoney +
                '}';
    }


}
