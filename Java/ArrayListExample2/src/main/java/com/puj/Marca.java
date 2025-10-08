package com.puj;

import java.util.ArrayList;

public class Marca {
    private String nombre;
    private String pais;
    private ArrayList<Carro> carros; // Relación: una marca tiene varios carros

    public Marca(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
        this.carros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public ArrayList<Carro> getCarros() {
        return carros;
    }

    // Método para agregar un carro a la marca
    public void agregarCarro(Carro carro) {
        carros.add(carro);
    }

    @Override
    public String toString() {
        return "Marca{" +
                "nombre='" + nombre + '\'' +
                ", país='" + pais + '\'' +
                ", cantidadCarros=" + carros.size() +
                '}';
    }
}