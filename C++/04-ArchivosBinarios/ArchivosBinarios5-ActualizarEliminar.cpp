#include <fstream>
#include <iomanip>
#include <iostream>

using namespace std;

struct Cuenta {
    int numero;
    char titular[40];
    double saldo;
    bool activa;
};

streamoff posicionRegistro(int indice) {
    return static_cast<streamoff>(indice) * sizeof(Cuenta);
}

void listarCuentas(const char* nombreArchivo) {
    ifstream archivo(nombreArchivo, ios::binary);
    Cuenta cuenta;

    cout << "\nCuentas activas:\n";
    cout << fixed << setprecision(2);
    while (archivo.read(reinterpret_cast<char*>(&cuenta), sizeof(Cuenta))) {
        if (cuenta.activa) {
            cout << cuenta.numero << " | " << cuenta.titular
                 << " | $" << cuenta.saldo << "\n";
        }
    }
}

int main() {
    const char* nombreArchivo = "cuentas.dat";
    Cuenta cuentas[] = {
        {1001, "Ana Torres", 1200000.0, true},
        {1002, "Luis Rojas", 850000.0, true},
        {1003, "Sara Diaz", 430000.0, true}
    };

    ofstream salida(nombreArchivo, ios::binary);
    if (!salida) {
        cerr << "No se pudo crear el archivo.\n";
        return 1;
    }
    salida.write(reinterpret_cast<const char*>(cuentas), sizeof(cuentas));
    salida.close();

    fstream archivo(nombreArchivo, ios::in | ios::out | ios::binary);
    if (!archivo) {
        cerr << "No se pudo abrir el archivo para actualizarlo.\n";
        return 1;
    }

    Cuenta cuenta;
    archivo.seekg(posicionRegistro(1), ios::beg);
    archivo.read(reinterpret_cast<char*>(&cuenta), sizeof(Cuenta));
    cuenta.saldo += 150000.0;
    archivo.seekp(posicionRegistro(1), ios::beg);
    archivo.write(reinterpret_cast<const char*>(&cuenta), sizeof(Cuenta));

    archivo.seekg(posicionRegistro(0), ios::beg);
    archivo.read(reinterpret_cast<char*>(&cuenta), sizeof(Cuenta));
    cuenta.activa = false;
    archivo.seekp(posicionRegistro(0), ios::beg);
    archivo.write(reinterpret_cast<const char*>(&cuenta), sizeof(Cuenta));
    archivo.close();

    cout << "Se actualizo el saldo de la cuenta 1002.\n";
    cout << "Se elimino logicamente la cuenta 1001.\n";
    listarCuentas(nombreArchivo);

    return 0;
}