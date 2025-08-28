#include <iostream>
#include <cstring>  // strtok
using namespace std;

int main() {
    char* texto = new char[200];
    strcpy(texto, "Juan-Perez;  Maria--Lopez;Carlos  -Martinez;Ana");

    cout << "Texto original:\n" << texto << "\n\n";

    // === PRIMERA ETAPA: separar por ';' ===
    char* token1 = strtok(texto, ";");

    int grupo = 1;
    while (token1 != nullptr) {
        cout << ">> Grupo " << grupo << ": " << token1 << endl;

        // === SEGUNDA ETAPA: separar dentro del grupo por '-' ===
        char* subToken = strtok(token1, "-");
        int sub = 1;
        while (subToken != nullptr) {
            cout << "   SubToken " << sub << ": " << subToken << endl;

            // === TERCERA ETAPA: separar cada subtoken por espacios ===
            char* palabra = strtok(subToken, " ");
            int p = 1;
            while (palabra != nullptr) {
                cout << "      Palabra " << p << ": " << palabra << endl;
                palabra = strtok(nullptr, " ");
                p++;
            }

            subToken = strtok(nullptr, "-");
            sub++;
        }

        token1 = strtok(nullptr, ";");
        grupo++;
    }

    delete[] texto;
    return 0;
}
