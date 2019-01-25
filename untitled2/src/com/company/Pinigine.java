package com.company;

public class Pinigine {
    private int eur100,eur50,eur20,eur10,eur5;

    public void setEur100(int eur100) {
        this.eur100 = eur100;
    }

    public void setEur50(int eur50) {
        this.eur50 = eur50;
    }

    public void setEur20(int eur20) {
        this.eur20 = eur20;
    }

    public void setEur10(int eur10) {
        this.eur10 = eur10;
    }

    public void setEur5(int eur5) {
        this.eur5 = eur5;
    }

    public int getEur100() {
        return eur100;
    }

    public int getEur50() {
        return eur50;
    }

    public int getEur20() {
        return eur20;
    }

    public int getEur10() {
        return eur10;
    }

    public int getEur5() {
        return eur5;
    }

    public Pinigine(int eur100, int eur50, int eur20, int eur10, int eur5) {
        this.eur100 = eur100;
        this.eur50 = eur50;
        this.eur20 = eur20;
        this.eur10 = eur10;
        this.eur5 = eur5;
    }

    public void parodyk(){
        System.out.println("Pinigine:\n" +
                "eur100: " + eur100 +
                "\neur50: " + eur50 +
                "\neur20: " + eur20 +
                "\neur10: " + eur10 +
                "\neur5: " + eur5
                );
    }

    public void suma(){
        int suma = 100*eur100+50*eur50+20*eur20+10*eur10+5*eur5;
        System.out.println("Pinigines suma: "+suma);
    }

    @Override
    public String toString() {
        return "Pinigine{" +
                "eur100=" + eur100 +
                ", eur50=" + eur50 +
                ", eur20=" + eur20 +
                ", eur10=" + eur10 +
                ", eur5=" + eur5 +
                '}';
    }
}
