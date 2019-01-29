package com.company;

import java.util.List;

public class Monitoring {

    public Monitoring() {
    }

    public void pingAllDevices(List<Device> devices) {
        System.out.println("-----Pinging started-----");
        for (Device d : devices) {
            try {
                Device.ping(d);
            }catch (DeviceIsOffException e){

            }

        }
        System.out.println("-----Pinging finished----");
    }

}
