#include <iostream>
#include <fstream>
using namespace std;

struct Estudiante {
    char nombre[30];
    int edad;
    float promedio;
};

int main() {
    ofstream archivo("estudiantes.dat", ios::binary);
    if (!archivo) {
        cerr << "No se pudo abrir el archivo para escritura.\n";
        return 1;
    }

    int cantidad;
    cout << "¿Cuántos estudiantes deseas registrar? ";
    cin >> cantidad;
    cin.ignore();  // Limpiar buffer

    for (int i = 0; i < cantidad; ++i) {
        Estudiante e;
        cout << "\nEstudiante #" << (i + 1) << ":\n";

        cout << "Nombre: ";
        cin.getline(e.nombre, 30);

        cout << "Edad: ";
        cin >> e.edad;

        cout << "Promedio: ";
        cin >> e.promedio;

        cin.ignore();  // Limpiar buffer antes de la siguiente entrada

        archivo.write((char*)&e, sizeof(Estudiante));
        /*
            Cuando trabajamos con archivos binarios, usamos:

                archivo.write((char*)&e, sizeof(Estudiante));
                lectura.read((char*)&e, sizeof(Estudiante));

            Esto indica cuántos bytes deben escribirse o leerse del archivo.

            sizeof(Estudiante) nos dice cuántos bytes ocupa en memoria una variable de tipo `Estudiante`.
            Esto incluye todos sus campos: el arreglo `nombre[30]`, el `int edad` y el `float promedio`: 38 bytes
        */
    }

    archivo.close();

    // --- Lectura de todos los registros ---
    ifstream lectura("estudiantes.dat", ios::binary);
    if (!lectura) {
        cerr << "No se pudo abrir el archivo para lectura.\n";
        return 1;
    }

    cout << "\n=== Estudiantes Guardados ===\n";
    Estudiante e;
    int contador = 1;
    while (lectura.read((char*)&e, sizeof(Estudiante))) {
        cout << "\nEstudiante #" << contador++ << ":\n";
        cout << "Nombre: " << e.nombre << "\n";
        cout << "Edad: " << e.edad << "\n";
        cout << "Promedio: " << e.promedio << "\n";
    }

    lectura.close();
    return 0;
}