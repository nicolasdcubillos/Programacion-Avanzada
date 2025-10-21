package com.puj;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App
{
    public static void verificarEdad(int edad) throws EdadInvalidaException {
        if (edad < 18) {
            throw new EdadInvalidaException();
        }
        System.out.println("Edad valida.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad;
        try {
            edad = sc.nextInt();
            verificarEdad(edad);
        } catch (Exception e) {
            System.out.println(e.getClass().toString() + " - " + e.getMessage());
        }
    }

    public static void main2( String[] args )
    {
        Scanner sc =  new Scanner(System.in);
        Boolean error = true;
            while (error) {
            try {
                // División entre cero
                System.out.print("Ingrese un número para dividir 100: ");
                int divisor = sc.nextInt();
                int resultado = 100 / divisor; // Posible ArithmeticException
                System.out.println("Resultado: " + resultado);

                // Acceso a un índice fuera de rango
                int[] numeros = {10, 20, 30};
                System.out.print("Ingrese un índice (0 a 2): ");
                int indice = sc.nextInt();
                System.out.println("Valor en el índice: " + numeros[indice]);

                // Conversión de texto a número
                sc.nextLine(); // limpiar buffer
                System.out.print("Ingrese un número entero (texto): ");
                String textoNumero = sc.nextLine();
                int numeroConvertido = Integer.parseInt(textoNumero);
                System.out.println("Número convertido: " + numeroConvertido);
                error = false;
            } catch (NumberFormatException e) {
                System.out.println("No se pudo convertir de tipo de dato String a Integer.");
            } catch (InputMismatchException e) {
                System.out.println("Ingreso un tipo de dato incorrecto.");
            } catch (ArithmeticException e) {
                System.out.println("Ocurrio un error aritmetico");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Se desbordo del arreglo!");
            } catch (Exception e) {
                System.out.println("Ocurrio un error de tipo " + e.getClass().toString() + ": " + e.getMessage());
            } finally {
                System.out.println("Termino el try/catch");
            }

        }
    }
}
