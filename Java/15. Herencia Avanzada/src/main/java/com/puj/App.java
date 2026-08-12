package com.puj;

public class App {
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();

        empleados.add(new EmpleadoFijo("Nicolás", 2_500_000));
        empleados.add(new EmpleadoPorHoras("María", 160, 18_000));
        empleados.add(new EmpleadoComision("Carlos", 30_000_000, 0.05));

        System.out.println("=== Nómina de empleados ===");
        double totalNomina = 0;

        for (Empleado e : empleados) {
            e.mostrarInfo(); // Polimorfismo: cada uno ejecuta su propia versión
            totalNomina += e.calcularSalario();
            System.out.println("--------------------------");
        }

        System.out.println("Total a pagar en nómina: " + totalNomina);
    }
}