package com.puj;

import entidad.Persona;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Persona.mostrarContador();

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la persona 1: ");
        String nombre1 = sc.nextLine();
        System.out.print("Ingrese la edad de la persona 1: ");
        Integer edad1 = sc.nextInt();
        System.out.print("Ingrese la cedula de la persona 1: ");
        Integer cedula1 = sc.nextInt();
        System.out.print("Ingrese la altura de la persona 1: ");
        Float altura = sc.nextFloat();
        Persona p1 = new Persona(nombre1, edad1, cedula1, altura);
        System.out.println(p1.toString());
        System.out.println(p1.saludar());
    }
}
