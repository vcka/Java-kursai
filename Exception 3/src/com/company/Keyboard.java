package com.company;

public class Keyboard extends Device {
    public Keyboard(boolean b) {
        super(b);
    }
    @Override
    public String toString() {
        return "Device{ Keyboard with id " + super.getId() +
                " is " +
                (super.isOn() ? "ON" : "OFF") +
                '}';
    }
}
