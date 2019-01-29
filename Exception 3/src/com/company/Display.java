package com.company;

public class Display extends Device {
    public Display(boolean b) {
        super(b);
    }
    @Override
    public String toString() {
        return "Device{ Display with id " + super.getId() +
                " is " +
                (super.isOn() ? "ON" : "OFF") +
                '}';
    }
}
