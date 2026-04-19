#include <iostream>
using namespace std;

int main() {
    string nombre;
    char inicial;
    string frase;

    // === cin ===
    cout << "Ingrese su primer nombre (sin espacios): ";
    cin >> nombre; // Solo toma hasta el primer espacio
    cout << "Hola, " << nombre << "!" << endl;

    // Limpiar el salto de línea que dejó el cin anterior
    cin.ignore();

    // === cin.get ===
    cout << "Ingrese la primera letra de su apellido: ";
    inicial = cin.get(); // Lee un solo carácter (incluso un espacio si eso se tecleó)
    cout << "Inicial capturada: " << inicial << endl;

    // Limpiar buffer si es necesario
    cin.ignore(); // para evitar que afecte getline si queda '\n'

    // === getline ===
    cout << "Escriba una frase completa: ";
    getline(cin, frase); // Lee toda la línea, incluidos espacios
    cout << "Frase leída: " << frase << endl;

    return 0;
}
