package com.company;

import java.util.List;

class Monitoring {

    void pingAllDevices(List<Device> devices) {
        System.out.println("-----Pinging started-----");
        for (Device d : devices) {
            try {
                d.ping();
                System.out.println(String.format("Device %s with id %d is ON.", d.getClass().getSimpleName(), d.getId()));
            } catch (DeviceIsOffException e) {
                System.out.println(String.format("Device %s with id %d is OFF.", d.getClass().getSimpleName(), d.getId()));
            }
        }
        System.out.println("-----Pinging finished----");
    }

}
