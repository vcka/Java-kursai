package com.company;

import java.util.ArrayList;
import java.util.List;

public class Kalade {

    private enum mostis {
        SIRDIS(1), KRYZIUS(2), VYNAS(3), bugnas(4);
        private int value;

        private mostis(int value) {
            this.value = value;
        }
    }

    List<Korta> kalade = new ArrayList<>();

    public List<Korta> getKalade() {
        return kalade;
    }

    public void setKalade(List<Korta> kalade) {
        this.kalade = kalade;
    }

    public Kalade(List<Korta> kalade) {
        this.kalade = kalade;
    }
}
