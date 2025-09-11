#include <iostream>
#include <fstream>
#include <cstring>
using namespace std;

struct Producto {
    char NombreTienda[100];
    char URLTienda[200];
    char NombreProducto[300];
    char FechaVigenciaPromocion[11]; // dd/mm/yyyy + '\0'
    double Precio;
};

bool EsMayor(char *fecha1, char *fecha2) {
    // Copias para no alterar las originales
    char f1[11], f2[11];
    strcpy(f1, fecha1);
    strcpy(f2, fecha2);

    char *token1 = strtok(f1, "/");
    int d1 = atoi(token1);
    token1 = strtok(NULL, "/");
    int m1 = atoi(token1);
    token1 = strtok(NULL, "/");
    int a1 = atoi(token1);

    char *token2 = strtok(f2, "/");
    int d2 = atoi(token2);
    token2 = strtok(NULL, "/");
    int m2 = atoi(token2);
    token2 = strtok(NULL, "/");
    int a2 = atoi(token2);

    if (a1 != a2) return a1 > a2;
    if (m1 != m2) return m1 > m2;
    return d1 > d2;
}

struct Resultado {
    Producto *productos;
    int cantidad;
};

Resultado BuscarProductos(char *FechaBuscar, char *Nombre) {
    ifstream archivo("productos.dat", ios::binary);
    if (!archivo) {
        cout << "No se pudo abrir productos.dat" << endl;
        return {nullptr, 0};
    }

    Producto temp;
    Producto *resultado = nullptr;
    int tam = 0;

    while (archivo.read((char*)&temp, sizeof(Producto))) {
        // Verificar si el nombre contiene la subcadena
        if (strstr(temp.NombreProducto, Nombre) != nullptr) {
            if (!EsMayor(FechaBuscar, temp.FechaVigenciaPromocion)) {
                Producto *nuevo = new Producto[tam + 1];
                for (int i = 0; i < tam; i++) {
                    * (nuevo + i) = * (resultado + i);
                }
                * (nuevo + tam) = temp;
                delete[] resultado;
                resultado = nuevo;
                tam++;
            }
        }
    }

    archivo.close();
    return {resultado, tam};
}

void OrdenarYGuardar(Resultado r) {
    for (int i = 0; i < r.cantidad - 1; i++) {
        for (int j = 0; j < r.cantidad - i - 1; j++) {
            if ((r.productos + j)->Precio > (r.productos + j + 1)->Precio) {
                Producto aux = * (r.productos + j);
                * (r.productos + j) = * (r.productos + j + 1);
                * (r.productos + j + 1) = aux;
            }
        }
    }

    ofstream out("Mejores.txt");
    int limite = (r.cantidad < 5) ? r.cantidad : 5;

    for (int i = 0; i < limite; i++) {
        Producto *p = (r.productos + i);
        out << p->NombreTienda << ","
            << p->URLTienda << ","
            << p->NombreProducto << ","
            << p->FechaVigenciaPromocion << ","
            << p->Precio << endl;
    }

    out.close();
}

void CrearArchivoProductos() {
    ofstream out("productos.dat", ios::binary);
    if (!out) {
        cout << "Error creando productos.dat" << endl;
        return;
    }

    Producto p1 = {"Tiendas Jupiter", "www.jupiter.com", "Parlantes tipo 1", "30/03/2023", 175000};
    Producto p2 = {"Yelao", "yelao.com", "Llantas marca a", "13/02/2023", 400000};
    Producto p3 = {"Logro", "logro.com", "Parlantes tipo 1", "28/03/2023", 172000};
    Producto p4 = {"Llanticas.com", "www.llanticas.com", "Llantas marca a", "16/02/2023", 412000};
    Producto p5 = {"Supertienda", "super.com", "Llantas marca b", "20/02/2023", 390000};

    out.write((char*)&p1, sizeof(Producto));
    out.write((char*)&p2, sizeof(Producto));
    out.write((char*)&p3, sizeof(Producto));
    out.write((char*)&p4, sizeof(Producto));
    out.write((char*)&p5, sizeof(Producto));

    out.close();
    cout << "Archivo productos.dat creado con datos de prueba." << endl;
}


int main() {
    char fecha[] = "15/02/2023";
    char nombre[] = "Llantas";

    CrearArchivoProductos();

    Resultado r = BuscarProductos(fecha, nombre);
    if (r.cantidad == 0) {
        cout << "No se encontraron productos." << endl;
    } else {
        OrdenarYGuardar(r);
        cout << "Se guardaron los mejores productos en Mejores.txt" << endl;
    }

    delete[] r.productos;
    return 0;
}
