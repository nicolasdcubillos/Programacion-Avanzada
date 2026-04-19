/*
 * ArregloEstructurasConApuntadores.cpp
 * Tema: Recorrer arreglos de estructuras usando apuntadores
 * 
 * Muestra cómo acceder a los miembros de una estructura a través
 * de apuntadores y cómo recorrer un arreglo de estructuras
 * usando aritmética de apuntadores.
 */

#include <iostream>
#include <cstring>

using namespace std;

struct Producto {
    char nombre[30];
    double precio;
    int cantidad;
};

// Imprimir un producto usando apuntador (operador ->)
void imprimirProducto(Producto* p) {
    cout << "Nombre: " << p->nombre
         << " | Precio: $" << p->precio
         << " | Cantidad: " << p->cantidad << endl;
}

// Llenar arreglo de estructuras usando apuntadores
void llenar(Producto* productos, int n) {
    for (int i = 0; i < n; i++) {
        cout << "\nProducto " << (i + 1) << ":" << endl;
        cout << "Nombre: ";
        cin.getline((productos + i)->nombre, 30);  // Acceso con aritmética de apuntadores
        cout << "Precio: ";
        cin >> (productos + i)->precio;
        cout << "Cantidad: ";
        cin >> (productos + i)->cantidad;
        cin.ignore();  // Limpiar buffer
    }
}

// Imprimir arreglo recorriéndolo con un apuntador
void imprimirTodos(Producto* productos, int n) {
    Producto* ptr = productos;           // Apuntador al inicio del arreglo
    Producto* fin = productos + n;       // Apuntador al final (uno después del último)

    cout << "\n--- Lista de Productos ---" << endl;
    while (ptr < fin) {
        imprimirProducto(ptr);
        ptr++;  // Avanza sizeof(Producto) bytes en memoria
    }
}

// Buscar producto por nombre usando apuntador
Producto* buscarProducto(Producto* productos, int n, const char* nombre) {
    for (int i = 0; i < n; i++) {
        if (strcmp((productos + i)->nombre, nombre) == 0) {
            return (productos + i);  // Retorna apuntador al producto encontrado
        }
    }
    return nullptr;  // No se encontró
}

// Calcular el valor total del inventario
double valorTotal(Producto* productos, int n) {
    double total = 0;
    for (int i = 0; i < n; i++) {
        total += (productos + i)->precio * (productos + i)->cantidad;
    }
    return total;
}

int main() {
    const int N = 3;
    Producto inventario[N];

    // Llenar datos usando funciones con apuntadores
    llenar(inventario, N);

    // Imprimir todos los productos
    imprimirTodos(inventario, N);

    // Buscar un producto por nombre
    cout << "\n===== BÚSQUEDA =====" << endl;
    char buscar[30];
    cout << "Nombre del producto a buscar: ";
    cin.getline(buscar, 30);

    Producto* encontrado = buscarProducto(inventario, N, buscar);
    if (encontrado != nullptr) {
        cout << "Producto encontrado:" << endl;
        imprimirProducto(encontrado);

        // Modificar el precio usando el apuntador
        cout << "Nuevo precio: ";
        cin >> encontrado->precio;
        cout << "Precio actualizado." << endl;
    } else {
        cout << "Producto no encontrado." << endl;
    }

    // Valor total del inventario
    cout << "\nValor total del inventario: $" << valorTotal(inventario, N) << endl;

    return 0;
}
