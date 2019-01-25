package com.company;

public class Lapuotis extends Medis {
    public Lapuotis() {
        super.setLapas("Lapuotis");
        //System.out.println("Lapuotis");
    }
    @Override
    public boolean laikasKirtsti(){
        super.laikasKirtsti();
        if (super.getLitrai()>=2500) {
            return true;
        } else return false;
    }
}
