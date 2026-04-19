package com.puj;

class Pajaro extends Animal {
    public Pajaro(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " canta");
    }

    public void volar() {
        System.out.println(nombre + " está volando");
    }
}