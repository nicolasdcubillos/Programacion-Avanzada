package com.puj;

class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadas;
    private double valorHora;

    public EmpleadoPorHoras(String nombre, double salarioBase, int horasTrabajadas, double valorHora) {
        super(nombre, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (horasTrabajadas * valorHora);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("=== Empleado por Horas ===");
        super.mostrarInfo();
        System.out.println("Horas trabajadas: " + horasTrabajadas);
        System.out.println("Valor por hora: " + valorHora);
        System.out.println("Salario total: " + calcularSalario());
    }
}