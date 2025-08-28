// cadenas_basicas.cpp
#include <iostream>
#include <cstring>  // Librería para funciones de cadenas estilo C

using namespace std;

int main() {
    // 1. Declaración de cadenas de caracteres (arreglos de char)
    char saludo[20] = "Hola";  // se reserva espacio para 20 chars
    char nombre[20];           // cadena vacía (sin inicializar)

    // 2. Entrada de texto
    cout << "Ingresa tu nombre: ";
    cin.getline(nombre, 20);

    // 3. Operaciones básicas con <cstring>
    cout << "\n=== Operaciones con cadenas de char ===\n";

    // Longitud de la cadena
    cout << "Longitud de '" << nombre << "' es: " << strlen(nombre) << endl;

    // Copiar cadena
    char copia[20];
    strcpy(copia, nombre);
    cout << "Copia de nombre: " << copia << endl;

    // Concatenar cadenas
    strcat(saludo, " ");
    strcat(saludo, nombre);
    cout << "Concatenación: " << saludo << endl;

    // Comparar cadenas
    if (strcmp(nombre, "Santiago") == 0) {
        cout << "Tu nombre es exactamente 'Santiago'" << endl;
    } else {
        cout << "Tu nombre no es 'Santiago'" << endl;
    }

    // 4. Mostrar carácter por carácter
    cout << "\nCaracteres de tu nombre: ";
    for (int i = 0; i < strlen(nombre); i++) {
        cout << "[" << nombre[i] << "]";
    }
    cout << endl;

    return 0;
}