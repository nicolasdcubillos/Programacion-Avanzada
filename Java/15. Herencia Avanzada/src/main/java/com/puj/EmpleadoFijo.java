package com.puj;

public class EmpleadoFijo extends Empleado {
    private double bono;

    public EmpleadoFijo(String nombre, double salarioBase, double bono) {
        super(nombre, salarioBase);
        this.bono = bono;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + bono;
    }

    // Sobrescribimos el método mostrarInfo()
    @Override
    public void mostrarInfo() {
        System.out.println("=== Empleado Fijo ===");
        super.mostrarInfo();
        System.out.println("Bono: " + bono);
        System.out.println("Salario total: " + calcularSalario());
    }
}
