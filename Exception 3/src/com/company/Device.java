package com.company;

import java.util.concurrent.atomic.AtomicInteger;

public class Device {
    private static final AtomicInteger count = new AtomicInteger(-1);
    private boolean isOn;
    private int id;

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = count.incrementAndGet();
    }

    public Device(boolean isOn) {
        this.isOn = isOn;
        setId();
    }
    static void ping(Device d) throws DeviceIsOffException {
        try {
            if (!d.isOn) {throw new DeviceIsOffException();
            }
        }catch (DeviceIsOffException e) {
            System.out.printf("Device is off");
        }
//        System.out.println(d.toString());
    }

    @Override
    public String toString() {
        return "Device{" +
                "isOn=" + isOn +
                ", id=" + id +
                '}';
    }
}
