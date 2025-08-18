#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Ingrese el tamaño del arreglo: ";
    cin >> n;

    int* arr = new int[n];   // arreglo dinámico

    // Guardamos valores con notación de punteros
    for (int i = 0; i < n; i++) {
        cout << "Elemento " << i + 1 << ": ";
        cin >> *(arr + i);   // equivalente a arr[i]
    }

    // Mostramos los valores
    cout << "\nElementos ingresados: ";
    for (int i = 0; i < n; i++) {
        cout << *(arr + i) << " ";
    }

    delete[] arr;   // liberamos la memoria

    return 0;
}