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
                System.out.println(d.toString());
            }catch (DeviceIsOffException e){
                //System.out.println(d.toString());
            }

        }
        System.out.println("-----Pinging finished----");
    }

}
