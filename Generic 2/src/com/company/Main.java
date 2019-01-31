package com.company;

import com.sun.jndi.ldap.Ber;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Azuolas azuolas = new Azuolas();
        Berzas berzas = new Berzas();
        Egle egle = new Egle();
        Pusis pusis = new Pusis();
        Kadagys kadagys = new Kadagys();

        List<Medis> medisList = new ArrayList<>();
        medisList.add(azuolas);
        medisList.add(berzas);
        medisList.add(egle);
        medisList.add(pusis);
        medisList.add(kadagys);

        List<Spygliuotis> spygliuotis = new ArrayList<>();
        spygliuotis.add(egle);
        spygliuotis.add(pusis);
        spygliuotis.add(kadagys);

        List<Lapuotis> lapuotis = new ArrayList<>();
        lapuotis.add(azuolas);
        lapuotis.add(berzas);

        List<Berzas> berzas1 = new ArrayList<>();
        berzas1.add(berzas);
        berzas1.add(berzas);

        ivairusMiskas(medisList);
        spygliuociuMiskas(spygliuotis);
        berzuMiskas(berzas1);
    }

    public static void ivairusMiskas(List<? extends Medis> list) {
        System.out.printf("Ivairus miskas:");
        for (Medis medis : list) {
            medis.turi();
        }
        System.out.println();
    }

    public static void spygliuociuMiskas(List<? extends Spygliuotis> list) {
        System.out.println("Spygliuociu miskas:");
        for (Medis medis : list) {
            medis.turi();
        }
        System.out.println();
    }

    public static void berzuMiskas(List<? extends Berzas> list) {
        System.out.println("Berzu miskas:");
        for (Medis medis : list) {
            medis.turi();
        }
        System.out.println();
    }
}
