package com.company;

public class A {

    private X x;

    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }

    public A() {
        this.x = new X();
    }

    public int fibonacci(int n) {
        if (n <= 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
