package com.company;


import java.util.ArrayList;
import java.util.List;


public class Mapas <K, V>{
    List<Pora<K, V>> sarasasPoru = new ArrayList<>();

    public void ideti(K raktas, V reiksme){
        sarasasPoru.add(new Pora<>(raktas,reiksme));
    }

    public V gauti(K raktas){
        for (Pora<K,V> pora : sarasasPoru) {
            if (raktas.equals(pora.getRaktas())){
                return pora.getReiskme();
            }
        }
        throw new IllegalArgumentException();
//        return null;
    }
}



