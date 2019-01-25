package com.company;

public class Pajamos extends Biudzetas{

    Pajamos(){
        kategorijos.add("Atlyginimas");
        kategorijos.add("NT Nuoma");
        kategorijos.add("Stipendija");
        kategorijos.add("Pasalpa");
        kategorijos.add("Individuali Veikla");
        kategorijos.add("Dovana");
        kategorijos.add("Kita");

        sumos.add(0);
        sumos.add(0);
        sumos.add(0);
        sumos.add(0);
        sumos.add(0);
        sumos.add(0);
        sumos.add(0);
        sumos.add(0);

        suma = 0;
    }

    @Override
    public void spausdintiDetaliaInformacija() {
        System.out.println("Pajamos: ");
        super.spausdintiDetaliaInformacija();
    }
}