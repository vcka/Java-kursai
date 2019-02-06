package com.company;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Payment.generate(200).forEach(System.out::println);
        Payment.generate(20).forEach(System.out::println);
    }
}
