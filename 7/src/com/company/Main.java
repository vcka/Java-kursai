package com.company;

public class Main {

    public static void main(String[] args) {
        Darbuotojas darbuotojas = new Darbuotojas(500, 36);

        darbuotojas.pridetiAtlyginma();
        darbuotojas.pridetiAtlyginma();
        darbuotojas.pridetiDarba(20);
        darbuotojas.pridetiDarba(20);
        System.out.println(darbuotojas.gautiInfo());
    }
}
