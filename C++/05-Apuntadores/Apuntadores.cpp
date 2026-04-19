#include <iostream>
using namespace std;

int main() {
    int numero = 42;
    int* ptr; // Declaramos un puntero a entero

    ptr = &numero; // Guardamos la dirección de memoria de 'numero' en 'ptr'

    // Mostramos los valores
    cout << "Valor de numero: " << numero << endl;
    cout << "Dirección de memoria de numero (&numero): " << &numero << endl;

    cout << "\nValor del puntero ptr (es decir, la dirección que guarda): " << ptr << endl;
    cout << "Contenido al que apunta ptr (*ptr): " << *ptr << endl;

    // Modificamos el valor usando el puntero
    *ptr = 100;

    cout << "\nDespués de modificar *ptr:\n";
    cout << "Valor de numero: " << numero << endl;
    cout << "Contenido al que apunta ptr: " << *ptr << endl;

    return 0;
}