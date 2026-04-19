#include <iostream>
#include <cstring>
using namespace std;

struct Contacto {
    char nombre[50];     
    int numMensajes;      
    char** mensajes;      
};

void agregarMensaje(Contacto*& contactos, int& totalContactos, const char* nombreContacto, const char* nuevoMensaje) {
    // Buscar si el contacto ya existe
    for (int i = 0; i < totalContactos; i++) {
        if (strcmp((contactos + i)->nombre, nombreContacto) == 0) {
            // Aumentar tamaño del arreglo de mensajes
            char** temp = new char*[(contactos + i)->numMensajes + 1];
            for (int j = 0; j < (contactos + i)->numMensajes; j++) {
                *(temp + j) = *((contactos + i)->mensajes + j);
            }
            *(temp + (contactos + i)->numMensajes) = new char[strlen(nuevoMensaje) + 1];
            strcpy(*(temp + (contactos + i)->numMensajes), nuevoMensaje);

            delete[] (contactos + i)->mensajes;
            (contactos + i)->mensajes = temp;
            (contactos + i)->numMensajes++;
            return;
        }
    }

    // Si el contacto no existe, crear uno nuevo
    Contacto* tempContactos = new Contacto[totalContactos + 1];
    for (int i = 0; i < totalContactos; i++) {
        *(tempContactos + i) = *(contactos + i);
    }

    // Nuevo contacto
    strcpy((tempContactos + totalContactos)->nombre, nombreContacto);
    (tempContactos + totalContactos)->numMensajes = 1;
    (tempContactos + totalContactos)->mensajes = new char*[1];
    *((tempContactos + totalContactos)->mensajes + 0) = new char[strlen(nuevoMensaje) + 1];
    strcpy(*((tempContactos + totalContactos)->mensajes + 0), nuevoMensaje);

    delete[] contactos;
    contactos = tempContactos;
    totalContactos++;
}

// Función para mostrar todos los contactos y sus mensajes
void mostrarContactos(Contacto* contactos, int totalContactos) {
    for (int i = 0; i < totalContactos; i++) {
        cout << "Contacto: " << (contactos + i)->nombre 
             << " (" << (contactos + i)->numMensajes << " mensajes)" << endl;

        for (int j = 0; j < (contactos + i)->numMensajes; j++) {
            cout << "  " << j << ": " << *((contactos + i)->mensajes + j) << endl;
        }
        cout << endl;
    }
}

int main() {
    Contacto* contactos = nullptr;
    int totalContactos = 0;

    agregarMensaje(contactos, totalContactos, "Bruno", "Hola Zoe, como estas?");
    agregarMensaje(contactos, totalContactos, "Bruno", "Nos vemos para almorzar mañana?");
    agregarMensaje(contactos, totalContactos, "Zoe", "Hola Bruno, todo bien?");
    agregarMensaje(contactos, totalContactos, "Zoe", "Bru, terminaste el informe?");
    agregarMensaje(contactos, totalContactos, "Zoe", "Recuerda que la entrega es hoy a las 9am!");


    mostrarContactos(contactos, totalContactos);

    // Liberar memoria
    for (int i = 0; i < totalContactos; i++) {
        for (int j = 0; j < (contactos + i)->numMensajes; j++) {
            delete[] *((contactos + i)->mensajes + j);
        }
        delete[] (contactos + i)->mensajes;
    }
    delete[] contactos;

    return 0;
}
