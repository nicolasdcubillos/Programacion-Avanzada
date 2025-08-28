#include <iostream>
#include <cstring> // strtok, strcpy

using namespace std;

int main() {
    // Cadena larga con 3 grupos de datos
    char texto[] = "Nicolas;22;Bogota";

    // Tokenizar usando ';' como delimitador
    char* token = strtok(texto, ";");

    int contador = 1;
    while (token != nullptr) {
        if (contador == 1) {
            cout << "Nombre: " << token << endl;
        } else if (contador == 2) {
            cout << "Edad: " << token << endl;
        } else if (contador == 3) {
            cout << "Ciudad: " << token << endl;
        }
        token = strtok(nullptr, ";"); // siguiente token
        contador++;
    }

    return 0;
}