package com.puj;

import com.puj.entidad.*;

import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Vehiculo> lista = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\n--- MENÚ VEHÍCULOS ---");
            System.out.println("1. Agregar Auto");
            System.out.println("2. Agregar Moto");
            System.out.println("3. Mostrar Vehículos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: {
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    System.out.print("Puertas: ");
                    int puertas = sc.nextInt();

                    lista.add(new Auto(marca, modelo, precio, puertas));
                    System.out.println("Auto agregado con éxito.");
                    break;
                }
                case 2: {
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    System.out.print("Cilindrada (cc): ");
                    int cilindrada = sc.nextInt();

                    lista.add(new Moto(marca, modelo, precio, cilindrada));
                    System.out.println("Moto agregada con éxito.");
                }
                case 3: {
                    System.out.println("\n--- LISTA DE VEHÍCULOS ---");
                    if (lista.isEmpty()) {
                        System.out.println("No hay vehículos registrados.");
                    } else {
                        for (Vehiculo v : lista) {
                            v.mostrarInfo();
                            System.out.println("-----------------");
                        }
                    }
                }
                case 4: {
                    System.out.println("Saliendo del programa...");
                    break;
                }
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        sc.close();
    }
}
