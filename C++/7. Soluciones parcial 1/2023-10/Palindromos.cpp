#include <iostream>
#include <fstream>
#include <cstring>
using namespace std;

char* EliminarEspacios(char *cadena) {
    // Copiamos porque strtok modifica la cadena
    char copia[500];
    strcpy(copia, cadena);

    // Creamos un arreglo dinámico vacío
    char *resultado = new char[strlen(cadena) + 1];
    strcpy(resultado, ""); // inicializamos en cadena vacía

    char *token = strtok(copia, " ");
    while (token != nullptr) {
        strcat(resultado, token);   // concatenamos el token
        token = strtok(nullptr, " ");
    }

    return resultado;
}

bool EsPalindromo(char *frase) {
    char *sinEspacios = EliminarEspacios(frase);
    int len = strlen(sinEspacios);

    for (int i = 0; i < len / 2; i++) {
        if (*(sinEspacios + i) != *(sinEspacios + (len - 1 - i))) {
            delete[] sinEspacios;
            return false;
        }
    }

    delete[] sinEspacios;
    return true;
}

int ContarPalindromosEnArchivo(char *ruta) {
    ifstream archivo(ruta);
    if (!archivo) {
        cout << "No se pudo abrir el archivo" << endl;
        return 0;
    }

    const int MAX_LINEA = 500;
    char linea[MAX_LINEA];
    int contador = 0;

    while (archivo.getline(linea, MAX_LINEA)) {
        if (EsPalindromo(linea)) {
            contador++;
        }
    }

    archivo.close();
    return contador;
}

int main() {
    char frase1[] = "anita lava la tina";
    char frase2[] = "reconocer";
    char frase3[] = "esto no es";

    cout << frase1 << " -> " << (EsPalindromo(frase1) ? "SI" : "NO") << endl;
    cout << frase2 << " -> " << (EsPalindromo(frase2) ? "SI" : "NO") << endl;
    cout << frase3 << " -> " << (EsPalindromo(frase3) ? "SI" : "NO") << endl;

    char archivo[] = "frases.txt";
    cout << "Cantidad de palindromos en archivo: " << ContarPalindromosEnArchivo(archivo) << endl;

    return 0;
}
