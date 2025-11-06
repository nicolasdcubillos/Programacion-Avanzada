package com.puj;

public abstract class Animal {
    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    // Método abstracto (obligatorio en las subclases)
    public abstract void hacerSonido();

    // Método común (no abstracto)
    public void dormir() {
        System.out.println(nombre + " está durmiendo...");
    }
}
