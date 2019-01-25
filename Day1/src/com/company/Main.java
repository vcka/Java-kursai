package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        Shape shape = new Shape("Black");
        System.out.println(shape.getColor());
        shape.setColor("red");
        System.out.println(shape.toString());
        Circle circle = new Circle("purple", "A circle", 6);
        System.out.println(circle);
    }
}
