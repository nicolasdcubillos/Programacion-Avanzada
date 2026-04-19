#include <iostream>
using namespace std;

// Función para crear un arreglo dinámico
int* crearArreglo(int n) {
    return new int[n];
}

// Función para llenar el arreglo
void llenarArreglo(int* arr, int n) {
    cout << "Ingrese " << n << " elementos:" << endl;
    for (int i = 0; i < n; i++) {
        cin >> *(arr + i); 
    }
}

// Función para mostrar el arreglo
void mostrarArreglo(int* arr, int n) {
    for (int i = 0; i < n; i++) {
        cout << *(arr + i) << " ";
    }
    cout << endl;
}

// Función para redimensionar el arreglo
int* redimensionar(int* arr, int n, int nuevoTam) {
    int* nuevoArr = new int[nuevoTam];

    // Copiar los elementos que quepan
    int limite = (n < nuevoTam) ? n : nuevoTam;
    for (int i = 0; i < limite; i++) {
        *(nuevoArr + i) = *(arr + i);
    }

    delete[] arr;  // liberar arreglo viejo
    return nuevoArr;
}

int main() {
    int n;
    cout << "Tamaño inicial del arreglo: ";
    cin >> n;

    // Crear y llenar el arreglo inicial
    int* arr = crearArreglo(n);
    llenarArreglo(arr, n);

    cout << "Arreglo inicial: ";
    mostrarArreglo(arr, n);

    // Redimensionar
    int nuevoTam;
    cout << "\nNuevo tamaño del arreglo: ";
    cin >> nuevoTam;

    arr = redimensionar(arr, n, nuevoTam);

    cout << "Arreglo después de redimensionar: ";
    mostrarArreglo(arr, nuevoTam);

    // Liberar memoria final
    delete[] arr;

    return 0;
}