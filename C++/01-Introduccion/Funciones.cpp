/*
 * Funciones.cpp
 * Tema: Funciones en C++
 * 
 * Muestra declaración de funciones, paso de parámetros por valor,
 * funciones con retorno, funciones void, y prototipos.
 */

#include <iostream>

using namespace std;

// ===== PROTOTIPOS (declaración adelantada) =====
// Permite usar funciones antes de definirlas
void saludar();
int sumar(int a, int b);
double calcularPromedio(double notas[], int n);
void intercambiar(int &a, int &b);
int factorial(int n);

int main() {
    // ===== FUNCIÓN VOID SIN PARÁMETROS =====
    cout << "===== FUNCIÓN VOID =====" << endl;
    saludar();

    // ===== FUNCIÓN CON RETORNO =====
    cout << "\n===== FUNCIÓN CON RETORNO =====" << endl;
    int resultado = sumar(15, 25);
    cout << "sumar(15, 25) = " << resultado << endl;

    // ===== FUNCIÓN CON ARREGLO =====
    cout << "\n===== FUNCIÓN CON ARREGLO =====" << endl;
    double notas[] = {4.5, 3.8, 4.2, 3.0, 4.7};
    double prom = calcularPromedio(notas, 5);
    cout << "Promedio de notas: " << prom << endl;

    // ===== PASO POR REFERENCIA =====
    cout << "\n===== PASO POR REFERENCIA =====" << endl;
    int x = 10, y = 20;
    cout << "Antes: x = " << x << ", y = " << y << endl;
    intercambiar(x, y);  // Modifica los valores originales
    cout << "Después: x = " << x << ", y = " << y << endl;

    // ===== FUNCIÓN RECURSIVA =====
    cout << "\n===== FUNCIÓN RECURSIVA =====" << endl;
    for (int i = 0; i <= 10; i++) {
        cout << i << "! = " << factorial(i) << endl;
    }

    // ===== VALORES POR DEFECTO =====
    cout << "\n===== VALORES POR DEFECTO =====" << endl;
    // Se puede llamar con o sin el segundo argumento
    cout << "sumar(5, 3) = " << sumar(5, 3) << endl;

    return 0;
}

// ===== DEFINICIONES DE FUNCIONES =====

// Función sin retorno ni parámetros
void saludar() {
    cout << "¡Hola desde una función!" << endl;
}

// Función con retorno y dos parámetros (paso por valor)
int sumar(int a, int b) {
    return a + b;
}

// Función que recibe un arreglo (los arreglos siempre se pasan por referencia)
double calcularPromedio(double notas[], int n) {
    double suma = 0;
    for (int i = 0; i < n; i++) {
        suma += notas[i];
    }
    return suma / n;
}

// Función con paso por referencia usando &
void intercambiar(int &a, int &b) {
    int temp = a;
    a = b;
    b = temp;
}

// Función recursiva: factorial
int factorial(int n) {
    if (n <= 1) return 1;           // Caso base
    return n * factorial(n - 1);    // Caso recursivo
}
