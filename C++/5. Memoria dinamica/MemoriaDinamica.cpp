#include <iostream>

using namespace std;

struct Persona {
    int edad;
    float salario;
};

void llenarDatos(Persona* personas, int n) {
    for (int i = 0; i < n; i++) {
        cout << "Ingrese datos de la persona " << i << ": " << endl;
        cout << "Edad: ";
        cin >> (personas + i)->edad;
        cout << "Salario: ";
        cin >> (personas + i)->salario;
    }
}

void imprimirDatos(Persona* personas, int n) {
    for (int i = 0; i < n; i++) {
        cout << "Persona " << i << ": " << endl;
        cout << "Edad: " << (personas + i)->edad << endl;
        cout << "Salario: " << (personas + i)->salario << endl;
    }
}

void agregarPersona(Persona*& personas, int& n) {
    Persona* nuevoArr = new Persona[n + 1];
    
    for (int i = 0; i < n; i++) {
        *(nuevoArr + i) = *(personas + i);
    }
    
    cout << "Ingrese los datos de la nueva persona." << endl;
    cout << "Edad: ";
    cin >> (nuevoArr + n)->edad;
    cout << "Salario: ";
    cin >> (nuevoArr + n)->salario;
    
    delete[] personas;
    
    personas = nuevoArr;
    n++;
}

void eliminarPersona(Persona*& personas, int& n) {
    Persona* nuevoArr = new Persona[n - 1];
    
    for (int i = 0; i < n; i++) {
        *(nuevoArr + i) = *(personas + i);
    }
    
    delete[] personas;
    
    personas = nuevoArr;
    n--;
}

int main()
{
    int n, opcion;
    do {
        cout << "Ingrese la cantidad de personas que desea crear (numero positivo): ";
        cin >> n;
    } while (n <= 0);
    
    Persona* personas = new Persona[n];
    
    do {
        cout << "1. Llenar datos." << endl;
        cout << "2. Imprimir datos." << endl;
        cout << "3. Agregar una nueva persona." << endl;
        cout << "4. Eliminar la ultima persona." << endl;
        cout << "0. Salir" << endl;
        cout << "Ingrese su opcion: ";
        cin >> opcion;
        switch (opcion) {
            case 1: {
                llenarDatos(personas, n);
                break;
            }
            case 2: {
                imprimirDatos(personas, n);
                break;
            }
            case 3: {
                agregarPersona(personas, n);
                break;
            }
            case 4: {
                eliminarPersona(personas, n);
                break;
            }
        }
    } while (opcion != 0);
    
    
    return 0;
}