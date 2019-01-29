package com.company;

public class Mouse extends Device {
    public Mouse(boolean b) {
        super(b);
    }
    @Override
    public String toString() {
        return "Device{ Mouse with id " + super.getId() +
                " is " +
                (super.isOn() ? "ON" : "OFF") +
                '}';
    }
}
