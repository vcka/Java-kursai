package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, String> numbers = new HashMap<>();
        numbers.put(100, "Simtas");
        numbers.put(10, "Desimt");
        numbers.put(13, "Trylika");
        numbers.put(55, "Penkiasdesimt penki");
        numbers.put(32, "Trisdesimt du");
        numbers.put(40, "Keturiasdesimt");
        numbers.put(16, "Sesiolika");
        if (numbers.containsKey(100)) System.out.println("Raktas rastas");
        if (numbers.containsValue("Trylika")) System.out.println("Reiksme rastas");
        System.out.println(numbers.get(100));

        for (Integer key: numbers.keySet() ){

            System.out.println("Key: " + key + " Value: " + numbers.get(key));
        }
    }
}

