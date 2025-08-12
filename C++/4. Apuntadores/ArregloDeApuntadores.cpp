#include <iostream>
using namespace std;

int main() {
    int numeros[3] = {10, 20, 30};
    int* direcciones[3];

    // Guardar direcciones
    for (int i = 0; i < 3; i++) {
        *(direcciones + i) = (numeros + i);
    }

    // Mostrar valores usando el arreglo de apuntadores
    for (int i = 0; i < 3; i++) {
        cout << "Direccion: " << *(direcciones + i)
             << "  Valor: " << *(*direcciones + i) << endl;
    }

    return 0;
}