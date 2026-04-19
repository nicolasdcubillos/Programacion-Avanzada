#include <iostream>
using namespace std;

// Definimos la estructura
struct Estudiante {
    string nombre;
    int edad;
    float promedio;
};

int main() {
    int n;

    cout << "¿Cuántos estudiantes desea ingresar? ";
    cin >> n;

    // Creamos un arreglo dinámico de estructuras
    Estudiante* grupo = new Estudiante[n];

    // Llenamos los datos de cada estudiante usando ->
    for (int i = 0; i < n; i++) {
        cout << "\nEstudiante " << i + 1 << endl;
        cout << "Nombre: ";
        cin >> (grupo + i)->nombre;
        cout << "Edad: ";
        cin >> (grupo + i)->edad;
        cout << "Promedio: ";
        cin >> (grupo + i)->promedio;
    }

    // Mostramos la información
    cout << "\n=== Lista de estudiantes ===" << endl;
    for (int i = 0; i < n; i++) {
        cout << "Nombre: " << (grupo + i)->nombre
             << ", Edad: " << (grupo + i)->edad
             << ", Promedio: " << (grupo + i)->promedio << endl;
    }

    // Liberamos la memoria
    delete[] grupo;

    return 0;
}
