#include <iostream>
using namespace std;

int main() {
    int numeros[5] = {10, 20, 30, 40, 50};

    int* ptr = numeros; // Apuntador al primer elemento del arreglo

    cout << "Recorriendo arreglo con aritmetica de apuntadores:\n";
    for (int i = 0; i < 5; i++) {
        cout << "Direccion: " << (ptr + i) 
             << "  Valor: " << *(ptr + i) << endl;
    }

    return 0;
}
