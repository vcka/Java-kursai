package com.company;

public class Main {

    public static void main(String[] args) {
	Uosis uosis = new Uosis();
	Egle egle = new Egle();
    Berzas berzas = new Berzas();
    Azuolas azuolas = new Azuolas();
    Pusis pusis = new Pusis();

    uosis.laistyti(20000);
    pusis.laistyti(9000);

    uosis.informacija();
    egle.informacija();
    berzas.informacija();
    azuolas.informacija();
    pusis.informacija();

    if (uosis.laikasKirtsti()) System.out.println("Kertam uosi");
    if (egle.laikasKirtsti()) System.out.println("Kertam egle");
    if (berzas.laikasKirtsti()) System.out.println("Kertam berza");
    if (azuolas.laikasKirtsti()) System.out.println("Kertam azuola");
    if (pusis.laikasKirtsti()) System.out.println("Kertam pusi");
    }
}
