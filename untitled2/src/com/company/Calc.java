package com.company;

public class Calc {
    private double x,y;

    public Calc(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void suma(){
        double sum = x+y;
        System.out.println("Skaiciu suma: "+sum);
    }

    public void atimtis(){
        double sum = x-y;
        System.out.println("Skaiciu atimtis: "+sum);
    }

    public void daugyba(){
        double sum = x*y;
        System.out.println("Skaiciu daugyba: "+sum);
    }

    public void dalyba(){
        double sum = x/y;
        System.out.println("Skaiciu dalyba: "+sum);
    }

    public void liekana(){
        double sum = x%y;
        System.out.println("Skaiciu dalybos liekana: "+sum);
    }
}
