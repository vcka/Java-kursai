package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Telefonas telefonas = new Telefonas();
	telefonas.parodyk();

	Pinigine pinigine = new Pinigine(2,1,1,1,1);
        pinigine.parodyk();
        pinigine.suma();

        Scanner scn = new Scanner(System.in);
        System.out.println("Iveskite du skaicius: ");
        Calc calc = new Calc(scn.nextDouble(),scn.nextDouble());
        calc.suma();
        calc.atimtis();
        calc.daugyba();
        calc.dalyba();
        calc.liekana();
    }
}
