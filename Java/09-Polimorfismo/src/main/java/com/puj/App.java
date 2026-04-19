package com.puj;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Animal> animales = new ArrayList<>();

        animales.add(new Perro("Max"));
        animales.add(new Gato("Luna"));
        animales.add(new Pajaro("Piolín"));

        // Polimorfismo: todas las clases se comportan como "Animal"
        for (Animal a : animales) {
            a.hacerSonido(); // Llama al método sobreescrito según el tipo real
            a.dormir();

            // Uso de instanceof para comportamientos específicos
            if (a instanceof Perro) {
                ((Perro) a).moverCola();
            } else if (a instanceof Gato) {
                ((Gato) a).ronronear();
            } else if (a instanceof Pajaro) {
                ((Pajaro) a).volar();
            }

            System.out.println("---------------------");
        }
    }
}
