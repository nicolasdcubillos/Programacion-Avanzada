#include <iostream>
using namespace std;

int main() {
    int numeros[3] = {10, 20, 30};
    int *p = numeros; // Apunta al primer elemento

    // Mostrar todas las direcciones del arreglo original
    cout << "Direcciones y valores del arreglo original:" << endl;
    for (int i = 0; i < 3; i++) {
        cout << "Elemento " << i << " -> Direccion: " << &numeros[i]
             << " | Valor: " << numeros[i] << endl;
    }

    cout << "\nRecorriendo con aritmética de apuntadores:" << endl;
    cout << "Direccion p: " << p << " | Valor: " << *p << endl; 

    p++; // Avanzar al siguiente elemento
    cout << "Direccion p: " << p << " | Valor: " << *p << endl; 

    p += 1; // Avanzar otro elemento
    cout << "Direccion p: " << p << " | Valor: " << *p << endl; 

    p--; // Retroceder un elemento
    cout << "Direccion p: " << p << " | Valor: " << *p << endl;

    return 0;
}