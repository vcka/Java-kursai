package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Monitoring monitoring = new Monitoring();

        List<Device> devices = new ArrayList<>();
        devices.add(new Mouse(true));
        devices.add(new Display(true));
        devices.add(new Keyboard(true));
        devices.add(new Mouse(true));
        devices.add(new Display(true));
        devices.add(new Keyboard(true));

        monitoring.pingAllDevices(devices);
        devices.get(1).setOn(false);
        monitoring.pingAllDevices(devices);
    }
}

