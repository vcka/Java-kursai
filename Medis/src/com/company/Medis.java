package com.company;

import java.util.Random;

public class Medis {
    private int litrai;
    private int metai;
    private String rusis;
    private String lapas;

    public void auginti(){
        Random rand = new Random();
        this.metai = rand.nextInt((0)+30);
        this.litrai = rand.nextInt((0)+5000);
    }

    public int getLitrai() {
        return litrai;
    }

    public int getMetai() {
        return metai;
    }

    public void setLapas(String lapas) {
        this.lapas = lapas;
    }

    public void setRusis(String rusis) {
        this.rusis = rusis;
    }

    public void laistyti(int litrai){
        this.litrai+=litrai;
    }

    public boolean laikasKirtsti(){
        if (metai>=10&&litrai>=2000){
            return true;
        }else return false;

    }

    public void informacija(){
        System.out.println(this.lapas);
        System.out.println(this.rusis);
        System.out.println("Metai: "+this.metai);
        System.out.println("Litrai: "+this.litrai);
        System.out.println("--------------");
    }
}
