#include <iostream>
#include <cstring>  // strcpy
using namespace std;

int main() {
    char* origen = new char[50];
    cout << "Ingresa una palabra: ";
    cin >> origen;

    // Reservar memoria exacta para copia
    char* copia = new char[strlen(origen) + 1];
    strcpy(copia, origen);

    cout << "Copia realizada: " << copia << endl;

    delete[] origen;
    delete[] copia;
    return 0;
}