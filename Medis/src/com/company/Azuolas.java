package com.company;

public class Azuolas extends Lapuotis {
    public Azuolas() {
        super.auginti();
        super.setRusis("Azuolas");
    }

    @Override
    public boolean laikasKirtsti(){
        super.laikasKirtsti();
        if (super.getMetai()>=20) {
            return true;
        } else return false;
    }
}
