#include <cstdint>
#include <fstream>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

struct Libro {
    string titulo;
    string autor;
    int anio;
};

void escribirCadena(ofstream& archivo, const string& texto) {
    uint32_t longitud = static_cast<uint32_t>(texto.size());
    archivo.write(reinterpret_cast<const char*>(&longitud), sizeof(longitud));
    archivo.write(texto.data(), longitud);
}

bool leerCadena(ifstream& archivo, string& texto) {
    uint32_t longitud;
    if (!archivo.read(reinterpret_cast<char*>(&longitud), sizeof(longitud))) {
        return false;
    }

    texto.resize(longitud);
    return static_cast<bool>(archivo.read(texto.data(), longitud));
}

void escribirLibro(ofstream& archivo, const Libro& libro) {
    escribirCadena(archivo, libro.titulo);
    escribirCadena(archivo, libro.autor);
    archivo.write(reinterpret_cast<const char*>(&libro.anio), sizeof(libro.anio));
}

bool leerLibro(ifstream& archivo, Libro& libro) {
    if (!leerCadena(archivo, libro.titulo) || !leerCadena(archivo, libro.autor)) {
        return false;
    }

    return static_cast<bool>(
        archivo.read(reinterpret_cast<char*>(&libro.anio), sizeof(libro.anio))
    );
}

int main() {
    const char* nombreArchivo = "libros.dat";
    vector<Libro> libros = {
        {"Cien anios de soledad", "Gabriel Garcia Marquez", 1967},
        {"El principito", "Antoine de Saint-Exupery", 1943},
        {"Rayuela", "Julio Cortazar", 1963}
    };

    ofstream salida(nombreArchivo, ios::binary);
    if (!salida) {
        cerr << "No se pudo crear el archivo.\n";
        return 1;
    }

    uint32_t cantidad = static_cast<uint32_t>(libros.size());
    salida.write(reinterpret_cast<const char*>(&cantidad), sizeof(cantidad));
    for (const Libro& libro : libros) {
        escribirLibro(salida, libro);
    }
    salida.close();

    ifstream entrada(nombreArchivo, ios::binary);
    if (!entrada) {
        cerr << "No se pudo abrir el archivo.\n";
        return 1;
    }

    entrada.read(reinterpret_cast<char*>(&cantidad), sizeof(cantidad));
    cout << "Libros guardados: " << cantidad << "\n\n";

    for (uint32_t i = 0; i < cantidad; ++i) {
        Libro libro;
        if (!leerLibro(entrada, libro)) {
            cerr << "El archivo esta incompleto o danado.\n";
            return 1;
        }

        cout << libro.titulo << " - " << libro.autor
             << " (" << libro.anio << ")\n";
    }

    return 0;
}