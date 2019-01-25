package com.company;

public class Korta {

    private int mostis;
    private int reiksme;

    public Korta(int mostis, int reiksme) {
        this.mostis = mostis;
        this.reiksme = reiksme;
    }

    public int getMostis() {
        return mostis;
    }

    public void setMostis(int mostis) {
        if (mostis>0&&mostis<5)this.mostis = mostis;
    }

    public int getReiksme() {
        return reiksme;
    }

    public void setReiksme(int reiksme) {
        if (reiksme>1&&reiksme<15) this.reiksme = reiksme;
    }

    @Override
    public String toString() {
        return "Korta{" +
                "mostis=" + mostis +
                ", reiksme=" + reiksme +
                '}';
    }


}
