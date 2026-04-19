#include <iostream>
#include <cstring> // strtok, strcpy

using namespace std;

int main() {
    // Cadena con 3 grupos de datos
    char texto[] = "Nicolas;22;Bogota";

    // Primer token: nombre
    char* nombre = strtok(texto, ";");

    // Segundo token: edad
    char* edad = strtok(nullptr, ";");

    // Tercer token: ciudad
    char* ciudad = strtok(nullptr, ";");

    // Mostrar resultados
    cout << "Nombre: " << nombre << endl;
    cout << "Edad: " << edad << endl;
    cout << "Ciudad: " << ciudad << endl;

    return 0;
}