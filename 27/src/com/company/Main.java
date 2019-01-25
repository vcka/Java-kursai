package com.company;

public class Main {


    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        b.metodasX();
        a.getX().metodasX();

        int n = 6;
        for (int i = 0; i <= n; i++) {
            System.out.println(a.fibonacci(i));
        }
    }
}
