#include <iostream>
using namespace std;

int main() {
    int filas, columnas;

    cout << "Ingrese número de filas: ";
    cin >> filas;
    cout << "Ingrese número de columnas: ";
    cin >> columnas;

    // Creamos un arreglo de apuntadores a filas
    int** matriz = new int*[filas];

    // Para cada fila, creamos un arreglo dinámico de columnas
    for (int i = 0; i < filas; i++) {
        matriz[i] = new int[columnas];
    }

    // Llenamos la matriz usando notación de apuntadores
    cout << "\nIngrese los valores de la matriz:\n";
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            cout << "Elemento [" << i << "][" << j << "]: ";
            cin >> *(*(matriz + i) + j);  // equivalente a matriz[i][j]
        }
    }

    // Mostramos la matriz
    cout << "\n=== Matriz ingresada ===\n";
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            cout << *(*(matriz + i) + j) << " ";
        }
        cout << endl;
    }

    // Liberamos memoria
    for (int i = 0; i < filas; i++) {
        delete[] matriz[i];  // liberar cada fila
    }
    delete[] matriz;  // liberar arreglo de punteros

    return 0;
}