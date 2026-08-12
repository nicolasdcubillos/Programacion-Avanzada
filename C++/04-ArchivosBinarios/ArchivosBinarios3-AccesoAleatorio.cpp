#include <fstream>
#include <iostream>

using namespace std;

struct Producto {
    int codigo;
    char nombre[30];
    float precio;
};

void mostrarProducto(const Producto& producto) {
    cout << "Codigo: " << producto.codigo << "\n";
    cout << "Nombre: " << producto.nombre << "\n";
    cout << "Precio: $" << producto.precio << "\n";
}

int main() {
    const char* nombreArchivo = "productos.dat";
    Producto productos[] = {
        {101, "Teclado", 85000.0f},
        {102, "Mouse", 45000.0f},
        {103, "Monitor", 720000.0f}
    };

    ofstream salida(nombreArchivo, ios::binary);
    if (!salida) {
        cerr << "No se pudo crear el archivo.\n";
        return 1;
    }

    salida.write(reinterpret_cast<const char*>(productos), sizeof(productos));
    salida.close();

    int posicion;
    cout << "Posicion del producto que desea consultar (0-2): ";
    cin >> posicion;

    if (posicion < 0 || posicion >= 3) {
        cerr << "La posicion no es valida.\n";
        return 1;
    }

    ifstream entrada(nombreArchivo, ios::binary);
    if (!entrada) {
        cerr << "No se pudo abrir el archivo.\n";
        return 1;
    }

    entrada.seekg(posicion * sizeof(Producto), ios::beg);

    Producto producto;
    entrada.read(reinterpret_cast<char*>(&producto), sizeof(Producto));
    if (!entrada) {
        cerr << "No se pudo leer el registro.\n";
        return 1;
    }

    cout << "\nProducto encontrado:\n";
    mostrarProducto(producto);

    return 0;
}