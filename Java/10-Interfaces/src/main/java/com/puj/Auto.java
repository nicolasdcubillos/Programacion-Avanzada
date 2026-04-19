package com.puj;

class Auto implements Vehiculo {
    @Override
    public void acelerar() {
        System.out.println("El auto está acelerando");
    }

    @Override
    public void frenar() {
        System.out.println("El auto está frenando");
    }
}