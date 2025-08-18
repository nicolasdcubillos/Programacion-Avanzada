#include <iostream>
using namespace std;

// Definimos una estructura
struct Estudiante {
    string nombre;
    int edad;
    float promedio;
};

int main() {
    // Declaramos una variable de tipo estructura
    Estudiante e1 = {"Juan", 20, 4.5};

    // Declaramos un apuntador a la estructura
    Estudiante* ptr;

    // El apuntador apunta a la dirección de e1
    ptr = &e1;

    // Accediendo a los campos de la estructura con el apuntador
    cout << "Acceso con notacion -> " << endl;
    cout << "Nombre: " << ptr->nombre << endl;
    cout << "Edad: " << ptr->edad << endl;
    cout << "Promedio: " << ptr->promedio << endl;

    // También podemos modificar los valores a través del apuntador
    ptr->edad = 21;
    ptr->promedio = 4.8;

    cout << "\nValores modificados:" << endl;
    cout << "Nombre: " << ptr->nombre << endl;
    cout << "Edad: " << ptr->edad << endl;
    cout << "Promedio: " << ptr->promedio << endl;

    return 0;
}
