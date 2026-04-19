package com.puj;

import java.io.Serializable;

// La clase debe implementar Serializable para poder guardarse en un archivo binario
public class Persona implements Serializable {
    private String nombre;
    private int edad;

    // Es buena práctica incluir un serialVersionUID
    private static final long serialVersionUID = 1L;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    @Override
    public String toString() {
        return "Persona{" + "nombre='" + nombre + '\'' + ", edad=" + edad + '}';
    }
}