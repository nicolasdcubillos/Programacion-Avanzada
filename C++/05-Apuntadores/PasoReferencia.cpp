#include <iostream>
using namespace std;

// Paso por valor (no modifica el original)
void duplicarValor(int num) {
    num = num * 2; // Solo cambia la copia
}

// Paso por referencia usando apuntador
void duplicarPuntero(int *num) {
    *num = *num * 2; // Modifica el valor original
}

// Paso por referencia directa (C++)
void duplicarReferencia(int &num) {
    num = num * 2; // Modifica el valor original
}

int main() {
    int valor1 = 5, valor2 = 5, valor3 = 5;

    cout << "Inicialmente:" << endl;
    cout << "valor1 = " << valor1 << ", valor2 = " << valor2 << ", valor3 = " << valor3 << endl;

    // Paso por valor
    duplicarValor(valor1);
    cout << "\nDespués de paso por valor:" << endl;
    cout << "valor1 = " << valor1 << " (sin cambios)" << endl;

    // Paso por referencia con apuntador
    duplicarPuntero(&valor2);
    cout << "\nDespués de paso por referencia con apuntador:" << endl;
    cout << "valor2 = " << valor2 << " (modificado)" << endl;

    // Paso por referencia directa
    duplicarReferencia(valor3);
    cout << "\nDespués de paso por referencia directa:" << endl;
    cout << "valor3 = " << valor3 << " (modificado)" << endl;

    return 0;
}