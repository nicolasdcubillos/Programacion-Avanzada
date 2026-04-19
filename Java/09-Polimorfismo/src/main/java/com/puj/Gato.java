package com.puj;

class Gato extends Animal {
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Miau!");
    }

    public void ronronear() {
        System.out.println(nombre + " está ronroneando");
    }
}
