#include <iostream>
#include <iomanip>  // Para setw, fixed, setprecision, left, right
using namespace std;

int main() {
    // Encabezado de la tabla
    cout << left << setw(15) << "Producto"
         << right << setw(10) << "Precio"
         << right << setw(12) << "Cantidad"
         << right << setw(15) << "Total" << endl;

    cout << string(52, '-') << endl; // Línea separadora

    // Datos de productos
    string productos[] = {"Lapiz", "Cuaderno", "Borrador", "Regla"};
    float precios[] = {1.5, 4.25, 0.75, 2.0};
    int cantidades[] = {10, 5, 20, 7};

    // Mostrar cada producto con formato
    for (int i = 0; i < 4; i++) {
        float total = precios[i] * cantidades[i];
        cout << left << setw(15) << productos[i]
             << right << setw(10) << fixed << setprecision(2) << precios[i]
             << right << setw(12) << cantidades[i]
             << right << setw(15) << total << endl;
    }

    return 0;
}
