package com.puj;

/**
 * EmpleadoFijo hereda de Empleado.
 * Representa un empleado con salario mensual fijo más una bonificación.
 * Implementa el método abstracto calcularSalario().
 */
public class EmpleadoFijo extends Empleado {

    private double bonificacion;  // Porcentaje de bonificación (ej: 0.10 = 10%)

    public EmpleadoFijo(String nombre, String identificacion, double salarioBase, double bonificacion) {
        super(nombre, identificacion, salarioBase);  // Llamada al constructor de la clase padre
        this.bonificacion = bonificacion;
    }

    // Implementación del método abstracto
    // Salario = salario base + (salario base * bonificación)
    @Override
    public double calcularSalario() {
        return getSalarioBase() + (getSalarioBase() * bonificacion);
    }

    public double getBonificacion() { return bonificacion; }
    public void setBonificacion(double bonificacion) { this.bonificacion = bonificacion; }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Fijo | Bonificación: " + (bonificacion * 100) + "%";
    }
}
