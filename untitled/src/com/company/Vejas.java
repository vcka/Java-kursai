package com.company;

public class Vejas {
    private int vejasKm;
    private int vejasMz;
    private double vejasBe;

    public int getVejasKm() {
        return vejasKm;
    }

    public void setVejasKm(int vejasKm) {
        this.vejasKm = vejasKm;
    }

    public int getVejasMz() {
        return vejasMz;
    }

    public void setVejasMz(int vejasMz) {
        this.vejasMz = vejasMz;
    }

    public double getVejasBe() {
        return vejasBe;
    }

    public void setVejasBe(double vejasBe) {
        this.vejasBe = vejasBe;
    }

    public Vejas(int vejasKm) {
        this.vejasKm = vejasKm;
    }

    public String greitis(int km){
        if (km>=120) {
            return "Orcan";
        }
        if (km<=2) return "Ramu"; else return "Norma";
    }

    public int greitisBe(int km){
        Integer result = Math.toIntExact(Math.round(Math.pow(km / 3.01, (double) 2 / 3)));
        if (result>12) result=12;
        return result;
    }

    @Override
    public String toString() {
        return "Vejas{" +
                "vejasKm=" + vejasKm +
                ", vejasMz=" + vejasMz +
                ", vejasBe=" + vejasBe +
                '}';
    }
}
