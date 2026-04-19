package com.puj;

public class Calculadora {

    // Constante estática y final (no cambia nunca y pertenece a la clase)
    public static final double PI = 3.1416;

    // Método estático: no requiere crear un objeto para usarse
    public static int sumar(int a, int b) {
        return a + b;
    }

    // Sobrecarga de método: mismo nombre, diferentes parámetros
    public static double sumar(double a, double b) {
        return a + b;
    }

    // Otra sobrecarga: tres parámetros
    public static int sumar(int a, int b, int c) {
        return a + b + c;
    }

    // Método final: puede ser heredado, pero no sobrescrito
    public final void mostrarConstante() {
        System.out.println("El valor de PI es: " + PI);
    }
}
