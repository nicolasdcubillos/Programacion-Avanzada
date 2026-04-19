package com.puj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ejemplo de Herencia Avanzada:
 * - Clase abstracta (Empleado) con método abstracto (calcularSalario)
 * - Clases concretas (EmpleadoFijo, EmpleadoPorHoras) que implementan el método
 * - Sobre-escritura de métodos (@Override)
 * - Uso de super para invocar constructores y métodos del padre
 */
public class App {
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE EMPLEADOS =====");
            System.out.println("1. Agregar empleado fijo");
            System.out.println("2. Agregar empleado por horas");
            System.out.println("3. Listar empleados");
            System.out.println("4. Calcular nómina total");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Salario base: ");
                    double salarioBase = scanner.nextDouble();
                    System.out.print("Bonificación (ej: 0.10 para 10%): ");
                    double bonificacion = scanner.nextDouble();

                    // Se crea un EmpleadoFijo pero se almacena como Empleado
                    empleados.add(new EmpleadoFijo(nombre, id, salarioBase, bonificacion));
                    System.out.println("Empleado fijo agregado.");
                    break;

                case 2:
                    System.out.print("Nombre: ");
                    String nombre2 = scanner.nextLine();
                    System.out.print("ID: ");
                    String id2 = scanner.nextLine();
                    System.out.print("Salario base: ");
                    double salarioBase2 = scanner.nextDouble();
                    System.out.print("Horas trabajadas: ");
                    int horas = scanner.nextInt();
                    System.out.print("Valor por hora: ");
                    double valorHora = scanner.nextDouble();

                    empleados.add(new EmpleadoPorHoras(nombre2, id2, salarioBase2, horas, valorHora));
                    System.out.println("Empleado por horas agregado.");
                    break;

                case 3:
                    System.out.println("\n--- Lista de Empleados ---");
                    for (Empleado emp : empleados) {
                        // Cada empleado llama a su propia versión de toString() y calcularSalario()
                        System.out.println(emp);
                    }
                    break;

                case 4:
                    double total = 0;
                    for (Empleado emp : empleados) {
                        total += emp.calcularSalario();  // Polimorfismo en acción
                    }
                    System.out.println("Nómina total: $" + String.format("%.2f", total));
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
