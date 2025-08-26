#include <iostream>
#include <cstring>  // strcat
using namespace std;

int main() {
    char* nombre = new char[50];
    cout << "Ingresa tu nombre: ";
    cin >> nombre;

    const char* saludo = "Hola ";
    // Reservar memoria para concatenación
    char* resultado = new char[strlen(saludo) + strlen(nombre) + 1];
    
    strcpy(resultado, saludo);
    strcat(resultado, nombre);

    cout << "Resultado: " << resultado << endl;

    delete[] nombre;
    delete[] resultado;
    return 0;
}
