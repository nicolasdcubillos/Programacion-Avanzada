package com.puj;

public abstract class Empleado {
    protected String nombre;
    protected double salarioBase;

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    // Método abstracto que las subclases deben implementar
    public abstract double calcularSalario();

    // Método común que puede ser sobreescrito si se desea
    public void mostrarInfo() {
        System.out.println("Empleado: " + nombre);
        System.out.println("Salario base: " + salarioBase);
    }
}
