/*
 * MatricesEstaticas.cpp
 * Tema: Arreglos bidimensionales (matrices) estáticos en C++
 * 
 * Muestra declaración, recorrido, lectura y operaciones
 * básicas con matrices de tamaño fijo.
 */

#include <iostream>
#include <iomanip>

using namespace std;

const int MAX_FILAS = 10;
const int MAX_COLS = 10;

// Imprimir una matriz con formato
void imprimirMatriz(int matriz[][MAX_COLS], int filas, int cols) {
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < cols; j++) {
            cout << setw(5) << matriz[i][j];
        }
        cout << endl;
    }
}

// Sumar dos matrices
void sumarMatrices(int a[][MAX_COLS], int b[][MAX_COLS], int resultado[][MAX_COLS], int filas, int cols) {
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < cols; j++) {
            resultado[i][j] = a[i][j] + b[i][j];
        }
    }
}

// Transponer una matriz
void transponer(int original[][MAX_COLS], int transpuesta[][MAX_COLS], int filas, int cols) {
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < cols; j++) {
            transpuesta[j][i] = original[i][j];
        }
    }
}

int main() {
    // ===== DECLARACIÓN E INICIALIZACIÓN =====
    cout << "===== DECLARACIÓN E INICIALIZACIÓN =====" << endl;

    int matriz[3][3] = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    cout << "Matriz 3x3:" << endl;
    imprimirMatriz(matriz, 3, 3);

    // ===== LECTURA DESDE TECLADO =====
    cout << "\n===== LECTURA DESDE TECLADO =====" << endl;

    int filas, cols;
    cout << "Ingrese filas y columnas (max 10 10): ";
    cin >> filas >> cols;

    int m[MAX_FILAS][MAX_COLS];
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < cols; j++) {
            cout << "m[" << i << "][" << j << "] = ";
            cin >> m[i][j];
        }
    }

    cout << "\nMatriz ingresada:" << endl;
    imprimirMatriz(m, filas, cols);

    // ===== SUMA DE DIAGONAL PRINCIPAL =====
    if (filas == cols) {
        cout << "\n===== DIAGONAL PRINCIPAL =====" << endl;
        int sumaDiagonal = 0;
        for (int i = 0; i < filas; i++) {
            sumaDiagonal += m[i][i];
        }
        cout << "Suma de la diagonal principal: " << sumaDiagonal << endl;
    }

    // ===== SUMA DE MATRICES =====
    cout << "\n===== SUMA DE MATRICES =====" << endl;

    int a[MAX_COLS][MAX_COLS] = {{1, 2}, {3, 4}};
    int b[MAX_COLS][MAX_COLS] = {{5, 6}, {7, 8}};
    int resultado[MAX_COLS][MAX_COLS];

    sumarMatrices(a, b, resultado, 2, 2);

    cout << "Matriz A:" << endl;
    imprimirMatriz(a, 2, 2);
    cout << "Matriz B:" << endl;
    imprimirMatriz(b, 2, 2);
    cout << "A + B:" << endl;
    imprimirMatriz(resultado, 2, 2);

    // ===== TRANSPUESTA =====
    cout << "\n===== TRANSPUESTA =====" << endl;

    int original[MAX_COLS][MAX_COLS] = {{1, 2, 3}, {4, 5, 6}};
    int transpuesta[MAX_COLS][MAX_COLS];

    transponer(original, transpuesta, 2, 3);

    cout << "Original (2x3):" << endl;
    imprimirMatriz(original, 2, 3);
    cout << "Transpuesta (3x2):" << endl;
    imprimirMatriz(transpuesta, 3, 2);

    return 0;
}
