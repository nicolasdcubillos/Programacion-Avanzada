package com.puj;

class Perro extends Animal {
    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " ladra.");
    }

    public void moverCola() {
        System.out.println(nombre + " está moviendo la cola.");
    }
}