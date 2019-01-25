package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Pajamos pajamos = new Pajamos();
        Islaidos islaidos = new Islaidos();

        while(true){
            spausdintiMeniu();

            Scanner scanner = new Scanner(System.in);
            int choice;
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    pajamos.spausdintiKategorijas();
                    int choice2 = scanner.nextInt();
                    while(choice2 > 0 && choice2 < 8) {
                        System.out.println("Iveskite suma: ");
                        pajamos.setKategorijosSuma(choice2-1,scanner.nextInt());
                        pajamos.spausdintiKategorijas();
                        choice2 = scanner.nextInt();
                    }
                    break;
                case 2:
                    islaidos.spausdintiKategorijas();
                    choice2 = scanner.nextInt();
                    while(choice2 > 0 && choice2 < 10){
                        System.out.println("Iveskite suma: ");
                        islaidos.setKategorijosSuma(choice2-1,scanner.nextInt());
                        islaidos.spausdintiKategorijas();
                        choice2 = scanner.nextInt();
                    }
                    break;
                case 3:
                    pajamos.spausdintiDetaliaInformacija();
                    System.out.println("---------------------");
                    islaidos.spausdintiDetaliaInformacija();
                    System.out.println("---------------------");
                    System.out.println("Pajamos: "+ pajamos.getSuma()+"\u20ac");
                    System.out.println("Islaidos: "+ islaidos.getSuma()+"\u20ac");
                    System.out.println("---------------------");
                    System.out.println("Balansas: "+(pajamos.getSuma()-islaidos.getSuma())+"\u20ac");
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
    public static void spausdintiMeniu(){
        System.out.println("1. Iveskite pajamu informacija");
        System.out.println("2. Iveskite islaidu informacija");
        System.out.println("3. Parodyti duomenis");
        System.out.println("4. Baigti darba");

    }

}
