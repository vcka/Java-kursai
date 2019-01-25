package com.company;

public class Darbuotojas {
    private int atlyginimas;
    private int darbas;

    public Darbuotojas(){

    }

    public Darbuotojas(int atlyginimas, int darbas) {
        this.atlyginimas = atlyginimas;
        this.darbas = darbas;
    }

    public void pridetiAtlyginma() {
        if (this.atlyginimas < 500) this.atlyginimas = this.atlyginimas + 10;
    }

    public void pridetiDarba(int val) {
        this.atlyginimas += 5;
        this.darbas += val;
    }

    public String gautiInfo() {
        return "Darbuotojas{" +
                "atlyginimas=" + atlyginimas +
                ", darbas=" + darbas +
                '}';
    }
}
