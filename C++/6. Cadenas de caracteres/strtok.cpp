#include <iostream>
#include <cstring> // strtok, strcpy

using namespace std;

int main() {
    // Creamos la cadena en un buffer dinámico
    char* texto = new char[50]; // tamano suficiente
    strcpy(texto, "Hola mundo desde strtok");

    // Primer token, separador espacio
    char* token = strtok(texto, " ");

    while (token != nullptr) {
        cout << token << endl;
        token = strtok(nullptr, " ");
    }

    // Liberar memoria
    delete[] texto;

    return 0;
}
