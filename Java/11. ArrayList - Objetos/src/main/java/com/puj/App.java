package com.puj;

import java.util.ArrayList;

public class App 
{
    public static void main(String[] args) {
        // Crear marcas
        Marca toyota = new Marca("Toyota", "Japón");
        Marca bmw = new Marca("BMW", "Alemania");
        Marca ford = new Marca("Ford", "Estados Unidos");

        // Agregar carros a cada marca
        toyota.agregarCarro(new Carro("Corolla", 2020));
        toyota.agregarCarro(new Carro("Supra", 2022));

        bmw.agregarCarro(new Carro("X5", 2023));
        bmw.agregarCarro(new Carro("M3", 2021));

        ford.agregarCarro(new Carro("Mustang", 2021));
        ford.agregarCarro(new Carro("F-150", 2020));

        // Crear lista general de marcas
        ArrayList<Marca> marcas = new ArrayList<>();
        marcas.add(toyota);
        marcas.add(bmw);
        marcas.add(ford);

        // Mostrar las marcas y sus carros
        System.out.println("Listado de marcas con sus carros:");
        for (Marca m : marcas) {
            System.out.println("\n" + m.getNombre() + " (" + m.getPais() + "):");
            for (Carro c : m.getCarros()) {
                System.out.println(" - " + c);
            }
        }
    }
}
