/*
 * Vectores.cpp
 * Tema: Arreglos unidimensionales (vectores) en C++
 * 
 * Muestra declaración, inicialización, recorrido y operaciones
 * básicas sobre arreglos estáticos.
 */

#include <iostream>

using namespace std;

// Función para imprimir un arreglo
void imprimirArreglo(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

// Función para buscar un elemento en el arreglo
int buscar(int arr[], int n, int valor) {
    for (int i = 0; i < n; i++) {
        if (arr[i] == valor) {
            return i;  // Retorna la posición donde se encontró
        }
    }
    return -1;  // No se encontró
}

// Función para calcular el promedio
double promedio(int arr[], int n) {
    int suma = 0;
    for (int i = 0; i < n; i++) {
        suma += arr[i];
    }
    return static_cast<double>(suma) / n;
}

// Función para encontrar el mayor
int mayor(int arr[], int n) {
    int max = arr[0];
    for (int i = 1; i < n; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}

int main() {
    // ===== DECLARACIÓN E INICIALIZACIÓN =====
    cout << "===== DECLARACIÓN E INICIALIZACIÓN =====" << endl;

    int notas[5] = {85, 92, 78, 95, 88};  // Arreglo con valores iniciales
    int zeros[10] = {0};                    // Todos los elementos en 0
    int parcial[3] = {100, 90};             // El tercero se inicializa en 0

    cout << "Notas: ";
    imprimirArreglo(notas, 5);

    // ===== ACCESO Y MODIFICACIÓN =====
    cout << "\n===== ACCESO Y MODIFICACIÓN =====" << endl;

    cout << "Primer elemento: " << notas[0] << endl;
    cout << "Último elemento: " << notas[4] << endl;

    notas[2] = 80;  // Modificar el tercer elemento
    cout << "Después de modificar notas[2]: ";
    imprimirArreglo(notas, 5);

    // ===== LECTURA DESDE TECLADO =====
    cout << "\n===== LECTURA DESDE TECLADO =====" << endl;

    int n;
    cout << "¿Cuántas notas desea ingresar? (max 10): ";
    cin >> n;

    int calificaciones[10];
    for (int i = 0; i < n; i++) {
        cout << "Nota " << (i + 1) << ": ";
        cin >> calificaciones[i];
    }

    cout << "Notas ingresadas: ";
    imprimirArreglo(calificaciones, n);

    // ===== OPERACIONES CON FUNCIONES =====
    cout << "\n===== OPERACIONES =====" << endl;

    cout << "Promedio: " << promedio(calificaciones, n) << endl;
    cout << "Mayor nota: " << mayor(calificaciones, n) << endl;

    int valorBuscar;
    cout << "Ingrese un valor a buscar: ";
    cin >> valorBuscar;

    int pos = buscar(calificaciones, n, valorBuscar);
    if (pos != -1) {
        cout << "Encontrado en la posición " << pos << endl;
    } else {
        cout << "No se encontró el valor" << endl;
    }

    // ===== ORDENAMIENTO BURBUJA =====
    cout << "\n===== ORDENAMIENTO BURBUJA =====" << endl;

    // Copiar el arreglo para ordenar
    int ordenado[10];
    for (int i = 0; i < n; i++) {
        ordenado[i] = calificaciones[i];
    }

    // Algoritmo burbuja
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - 1 - i; j++) {
            if (ordenado[j] > ordenado[j + 1]) {
                int temp = ordenado[j];
                ordenado[j] = ordenado[j + 1];
                ordenado[j + 1] = temp;
            }
        }
    }

    cout << "Arreglo ordenado: ";
    imprimirArreglo(ordenado, n);

    return 0;
}
