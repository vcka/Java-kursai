package A;

import BCD.*;

public class A extends B {
    public static void main(String[] args) {
        B b = new B();
        D d = new D();
        System.out.println(b.z());
        System.out.println(b.getX());
        System.out.println(d.x);
        System.out.println(d.y);
    }


}
