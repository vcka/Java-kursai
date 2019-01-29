package com.company;

import java.util.concurrent.atomic.AtomicInteger;

class Device {
    private static final AtomicInteger count = new AtomicInteger(-1);
    private boolean isOn;
    private int id;

    void setOn(boolean on) {
        isOn = on;
    }

    int getId() {
        return id;
    }

    private void setId() {
        this.id = count.incrementAndGet();
    }

    Device(boolean isOn) {
        this.isOn = isOn;
        setId();
    }

    void ping() throws DeviceIsOffException {
        if (!isOn) {
            throw new DeviceIsOffException();
        }
    }

}
