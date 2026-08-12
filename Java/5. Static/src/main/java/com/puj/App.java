package com.puj;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        // Usar los métodos estáticos directamente desde la clase
        System.out.println("Suma de enteros: " + Calculadora.sumar(5, 10));
        System.out.println("Suma de doubles: " + Calculadora.sumar(3.5, 2.8));
        System.out.println("Suma de tres números: " + Calculadora.sumar(1, 2, 3));

        // Crear un objeto para llamar a un método no estático (final)
        Calculadora calc = new Calculadora();
        calc.mostrarConstante();

        // Intentar modificar una constante final daría error:
        // Calculadora.PI = 3.15; // NO se puede
    }
}