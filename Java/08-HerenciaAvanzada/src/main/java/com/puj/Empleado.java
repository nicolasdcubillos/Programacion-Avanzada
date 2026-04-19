package com.puj;

/**
 * Clase abstracta Empleado.
 * No se puede instanciar directamente, sirve como base para EmpleadoFijo y EmpleadoPorHoras.
 * Define el método abstracto calcularSalario() que cada subclase debe implementar.
 */
public abstract class Empleado {

    private String nombre;
    private String identificacion;
    private double salarioBase;

    // Constructor con parámetros
    public Empleado(String nombre, String identificacion, double salarioBase) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.salarioBase = salarioBase;
    }

    // Método abstracto: cada tipo de empleado calcula su salario de forma diferente
    public abstract double calcularSalario();

    // Método concreto: compartido por todas las subclases
    public String obtenerInfo() {
        return "Nombre: " + nombre + " | ID: " + identificacion;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    public double getSalarioBase() { return salarioBase; }
    public void setSalarioBase(double salarioBase) { this.salarioBase = salarioBase; }

    @Override
    public String toString() {
        return obtenerInfo() + " | Salario: $" + String.format("%.2f", calcularSalario());
    }
}
