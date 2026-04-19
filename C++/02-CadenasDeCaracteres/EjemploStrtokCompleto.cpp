#include <iostream>
#include <cstring>
using namespace std;

int main() {
    char* texto = new char[200];
    strcpy(texto, "Juan-Perez;Maria-Lopez;Carlos-Martinez;Ana");

    cout << "Texto original:\n" << texto << "\n\n";

    // Tokenizamos usando ';' y '-' como separadores
    char* token = strtok(texto, ";-");

    while (token != nullptr) {
        char* nombre = token; // primer token siempre nombre
        token = strtok(nullptr, ";-");

        char* apellido = nullptr;
        if (token != nullptr) {  // si hay otro token, es apellido
            apellido = token;
            token = strtok(nullptr, ";-"); // avanzar al siguiente grupo
        }

        // Mostrar resultado
        cout << "Nombre: " << nombre;
        if (apellido != nullptr)
            cout << " | Apellido: " << apellido;
        cout << endl;
    }

    delete[] texto;
    return 0;
}
