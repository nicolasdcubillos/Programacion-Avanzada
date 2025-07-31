#include <iostream>
#include <fstream>  // Para ifstream y ofstream
using namespace std;

int main() {
    // === ESCRITURA EN ARCHIVO ===
    ofstream archivoSalida("estudiantes.txt"); // Crea o sobrescribe el archivo

    if (!archivoSalida.is_open()) {
        cout << "No se pudo abrir el archivo para escritura." << endl;
        return 1;
    }

    // Escribimos algunos estudiantes
    archivoSalida << "Ana 4.5" << endl;
    archivoSalida << "Luis 3.8" << endl;
    archivoSalida << "Pedro 4.0" << endl;

    archivoSalida.close(); // Siempre cerrar el archivo

    // === LECTURA DESDE ARCHIVO ===
    ifstream archivoEntrada("estudiantes.txt");

    if (!archivoEntrada.is_open()) {
        cout << "No se pudo abrir el archivo para lectura." << endl;
        return 1;
    }

    string nombre;
    float nota;

    cout << "Contenido del archivo:" << endl;
    while (archivoEntrada >> nombre >> nota) {
        cout << "Estudiante: " << nombre << " | Nota: " << nota << endl;
    }

    archivoEntrada.close();

    return 0;
}
