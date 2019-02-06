package com.company;

public class Pora <K, V> {
    private K raktas;
    private  V reiskme;

    public Pora(K raktas, V reiskme) {
        this.raktas = raktas;
        this.reiskme = reiskme;
    }

    public K getRaktas() {
        return raktas;
    }

    public void setRaktas(K raktas) {
        this.raktas = raktas;
    }

    public V getReiskme() {
        return reiskme;
    }

    public void setReiskme(V reiskme) {
        this.reiskme = reiskme;
    }
}
