package com.puj;

/**
 * EmpleadoPorHoras hereda de Empleado.
 * Representa un empleado que cobra por horas trabajadas.
 * Implementa el método abstracto calcularSalario().
 */
public class EmpleadoPorHoras extends Empleado {

    private int horasTrabajadas;
    private double valorHora;

    public EmpleadoPorHoras(String nombre, String identificacion, double salarioBase, int horasTrabajadas, double valorHora) {
        super(nombre, identificacion, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }

    // Implementación del método abstracto
    // Salario = salario base + (horas trabajadas * valor por hora)
    @Override
    public double calcularSalario() {
        return getSalarioBase() + (horasTrabajadas * valorHora);
    }

    public int getHorasTrabajadas() { return horasTrabajadas; }
    public void setHorasTrabajadas(int horasTrabajadas) { this.horasTrabajadas = horasTrabajadas; }

    public double getValorHora() { return valorHora; }
    public void setValorHora(double valorHora) { this.valorHora = valorHora; }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Por Horas | Horas: " + horasTrabajadas + " | $/Hora: " + valorHora;
    }
}
