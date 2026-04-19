/*
 * Estructuras.cpp
 * Tema: Estructuras (struct) en C++
 * 
 * Muestra definición de estructuras, acceso a miembros,
 * arreglos de estructuras y funciones que reciben estructuras.
 */

#include <iostream>
#include <cstring>

using namespace std;

// ===== DEFINICIÓN DE ESTRUCTURA =====
struct Estudiante {
    char nombre[50];
    int edad;
    float promedio;
    char carrera[30];
};

// Estructura anidada (una estructura dentro de otra)
struct Fecha {
    int dia;
    int mes;
    int anio;
};

struct Empleado {
    char nombre[50];
    double salario;
    Fecha fechaIngreso;  // Estructura anidada
};

// ===== FUNCIONES CON ESTRUCTURAS =====

// Imprimir datos de un estudiante (paso por valor - copia)
void imprimirEstudiante(Estudiante est) {
    cout << "Nombre:   " << est.nombre << endl;
    cout << "Edad:     " << est.edad << endl;
    cout << "Promedio: " << est.promedio << endl;
    cout << "Carrera:  " << est.carrera << endl;
    cout << "---" << endl;
}

// Modificar datos (paso por referencia - modifica original)
void actualizarPromedio(Estudiante &est, float nuevoPromedio) {
    est.promedio = nuevoPromedio;
}

// Función que retorna una estructura
Estudiante crearEstudiante(const char* nombre, int edad, float promedio, const char* carrera) {
    Estudiante est;
    strcpy(est.nombre, nombre);
    est.edad = edad;
    est.promedio = promedio;
    strcpy(est.carrera, carrera);
    return est;
}

int main() {
    // ===== CREACIÓN Y ACCESO =====
    cout << "===== CREACIÓN Y ACCESO =====" << endl;

    Estudiante e1;
    strcpy(e1.nombre, "Ana García");  // Para char[] se usa strcpy
    e1.edad = 20;
    e1.promedio = 4.2;
    strcpy(e1.carrera, "Ingeniería");

    imprimirEstudiante(e1);

    // ===== INICIALIZACIÓN DIRECTA =====
    cout << "===== INICIALIZACIÓN DIRECTA =====" << endl;

    Estudiante e2 = {"Carlos López", 22, 3.8, "Sistemas"};
    imprimirEstudiante(e2);

    // ===== FUNCIÓN QUE RETORNA ESTRUCTURA =====
    cout << "===== CREACIÓN CON FUNCIÓN =====" << endl;

    Estudiante e3 = crearEstudiante("María Rodríguez", 21, 4.5, "Derecho");
    imprimirEstudiante(e3);

    // ===== MODIFICACIÓN POR REFERENCIA =====
    cout << "===== MODIFICACIÓN POR REFERENCIA =====" << endl;

    cout << "Promedio antes: " << e3.promedio << endl;
    actualizarPromedio(e3, 4.8);
    cout << "Promedio después: " << e3.promedio << endl;

    // ===== ARREGLO DE ESTRUCTURAS =====
    cout << "\n===== ARREGLO DE ESTRUCTURAS =====" << endl;

    const int N = 3;
    Estudiante estudiantes[N];

    // Llenar el arreglo
    for (int i = 0; i < N; i++) {
        cout << "\nEstudiante " << (i + 1) << ":" << endl;
        cout << "Nombre: ";
        cin.getline(estudiantes[i].nombre, 50);
        cout << "Edad: ";
        cin >> estudiantes[i].edad;
        cout << "Promedio: ";
        cin >> estudiantes[i].promedio;
        cin.ignore();  // Limpiar buffer antes del próximo getline
        cout << "Carrera: ";
        cin.getline(estudiantes[i].carrera, 30);
    }

    // Mostrar todos
    cout << "\n--- Lista de Estudiantes ---" << endl;
    for (int i = 0; i < N; i++) {
        imprimirEstudiante(estudiantes[i]);
    }

    // ===== ESTRUCTURA ANIDADA =====
    cout << "===== ESTRUCTURA ANIDADA =====" << endl;

    Empleado emp;
    strcpy(emp.nombre, "Pedro Martínez");
    emp.salario = 3500000;
    emp.fechaIngreso.dia = 15;
    emp.fechaIngreso.mes = 3;
    emp.fechaIngreso.anio = 2023;

    cout << "Empleado: " << emp.nombre << endl;
    cout << "Salario: $" << emp.salario << endl;
    cout << "Fecha ingreso: " << emp.fechaIngreso.dia << "/"
         << emp.fechaIngreso.mes << "/" << emp.fechaIngreso.anio << endl;

    return 0;
}
