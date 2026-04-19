#include <iostream>
#include <fstream>
using namespace std;

struct Estudiante {
    char nombre[30];
    int edad;
    float promedio;
};

int main() {
    Estudiante est1 = {"Juan Perez", 20, 4.5f};

    // --- Escritura en archivo binario ---
    ofstream archivoSalida("estudiante.bin", ios::binary);
    if (!archivoSalida) {
        cerr << "No se pudo abrir el archivo para escritura.\n";
        return 1;
    }

    archivoSalida.write((char*)&est1, sizeof(Estudiante));

    /*
        Cuando trabajamos con archivos binarios, usamos:

            archivo.write((char*)&e, sizeof(Estudiante));
            lectura.read((char*)&e, sizeof(Estudiante));

        Esto indica cuántos bytes deben escribirse o leerse del archivo.

        sizeof(Estudiante) nos dice cuántos bytes ocupa en memoria una variable de tipo `Estudiante`.
        Esto incluye todos sus campos: el arreglo `nombre[30]`, el `int edad` y el `float promedio`: 38 bytes
    */

    archivoSalida.close();

    // --- Lectura del archivo binario ---
    Estudiante est2;

    ifstream archivoEntrada("estudiante.bin", ios::binary);
    if (!archivoEntrada) {
        cerr << "No se pudo abrir el archivo para lectura.\n";
        return 1;
    }

    archivoEntrada.read((char*)&est2, sizeof(Estudiante));
    archivoEntrada.close();

    // Mostrar los datos leídos
    cout << "Datos leídos del archivo:\n";
    cout << "Nombre: " << est2.nombre << "\n";
    cout << "Edad: " << est2.edad << "\n";
    cout << "Promedio: " << est2.promedio << "\n";

    return 0;
}