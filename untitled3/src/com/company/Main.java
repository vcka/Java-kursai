package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
        int min = -2147483647;
        int max = 0;

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("Iveskite skaiciu: ");
            int numberEntered = sc.nextInt();
            if (min > numberEntered) {
                min = numberEntered;
            } else {
                max = numberEntered;
            }
        }
        System.out.println("Min: " + min + " Max: " + max);


        StringBuilder out = new StringBuilder();
        ArrayList<String> names = new ArrayList<>(asList("Jonas", "Petras", "Karolina", "Vytautas", "Gintaras", "Kristina", "Albertas", "Strump'as", "Vaiva", "Dainius"));

        for (int x = 0; x <= names.size() - 1; x++) {
            System.out.println("{" + names.get(x).toUpperCase() + "}-{" + names.get(x).length() + "}-{" + x + "}");
        }

        for (int cnt = 0; cnt < 10; cnt++) {
            System.out.println(out.append("*"));
        }
    }
}
