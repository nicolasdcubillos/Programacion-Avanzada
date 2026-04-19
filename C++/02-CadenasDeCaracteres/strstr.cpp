#include <iostream>
#include <cstring>
using namespace std;

int main() {
    char texto[] = "Hola mundo, programar en C++ es divertido";
    char sub1[] = "mundo";
    char sub2[] = "Python";

    // Buscar "mundo"
    char *resultado1 = strstr(texto, sub1);
    if (resultado1 != nullptr) {
        cout << "Se encontró \"" << sub1 << "\" en: " << resultado1 << endl;
    } else {
        cout << "No se encontró \"" << sub1 << "\"" << endl;
    }

    // Buscar "Python"
    char *resultado2 = strstr(texto, sub2);
    if (resultado2 != nullptr) {
        cout << "Se encontró \"" << sub2 << "\" en: " << resultado2 << endl;
    } else {
        cout << "No se encontró \"" << sub2 << "\"" << endl;
    }

    return 0;
}
