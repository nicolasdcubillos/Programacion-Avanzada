#include <iostream>
#include <cstring> // strcpy

using namespace std;

int main() {
    // Cadena original
    char texto[50];
    strcpy(texto, "Hola Mundo con STRLWR y STRUPR");

    cout << "Original: " << texto << endl;

    // Convertir a minúsculas
    cout << "Minusculas: " << strlwr(texto) << endl;

    // Volvemos a copiar la cadena original
    strcpy(texto, "Hola Mundo con STRLWR y STRUPR");

    // Convertir a mayúsculas
    cout << "Mayusculas: " << strupr(texto) << endl;

    return 0;
}
