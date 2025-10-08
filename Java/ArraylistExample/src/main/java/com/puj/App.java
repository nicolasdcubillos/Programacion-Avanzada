package com.puj;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // Crear una lista de personas
        ArrayList<Persona> personas = new ArrayList<>();

        // Agregar personas a la lista
        personas.add(new Persona("Nicolás", 22, "Colombia"));
        personas.add(new Persona("María", 25, "México"));
        personas.add(new Persona("Juan", 30, "Argentina"));
        personas.add(new Persona("Laura", 28, "Chile"));

        // Mostrar la lista completa
        System.out.println("Lista de personas:");
        for (Persona p : personas) {
            System.out.println(p);
        }

        // Ejemplo de acceso individual
        System.out.println("\nPrimera persona en la lista:");
        System.out.println(personas.get(0));

        // Ejemplo de cambio de datos
        personas.get(0).setEdad(23);
        System.out.println("\nDespués de actualizar la edad de la primera persona:");
        System.out.println(personas.get(0));
    }
}
