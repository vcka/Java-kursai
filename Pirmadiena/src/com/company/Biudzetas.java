package com.company;

import java.util.ArrayList;

public class Biudzetas {

    protected int suma;
    protected ArrayList<String> kategorijos = new ArrayList<>();
    protected ArrayList<Integer> sumos = new ArrayList<>();


    public int getSuma() {
        return suma;
    }

    public void spausdintiKategorijas(){
        for(int i = 0; i < this.kategorijos.size(); i++){
            System.out.println((i+1)+". "+kategorijos.get(i));

        }
        System.out.println(this.kategorijos.size()+1+". Grizti");
    }
    public void setKategorijosSuma(int index, int value){
        this.sumos.set(index, value);
        suma += value;
    }
    public void spausdintiDetaliaInformacija(){
        for(int i =0; i< kategorijos.size(); i++){
            System.out.println(kategorijos.get(i)+" : "+sumos.get(i)+"\u20ac");
        }
    }
}