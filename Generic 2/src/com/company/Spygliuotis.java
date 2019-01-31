package com.company;

public class Spygliuotis implements Medis {
    private String lapas;

    public String getLapas() {
        return lapas;
    }

    public void turi() {
        System.out.println(getLapas());
    }

    public void setLapas(String lapas) {
        this.lapas = lapas;
    }
}
