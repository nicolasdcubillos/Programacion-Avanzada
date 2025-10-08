package com.puj;

public class Carro {
    private String modelo;
    private int anio;

    public Carro(String modelo, int anio) {
        this.modelo = modelo;
        this.anio = anio;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return modelo + " (" + anio + ")";
    }
}