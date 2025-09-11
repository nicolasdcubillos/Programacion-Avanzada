#include <iostream>
#include <fstream>
#include <string.h>

using namespace std;

struct Paciente {
    char* cedula = new char [256];
    char* mayorSistolica = new char [256];
    char* mayorDiastolica = new char [256];
    char* mensajeAdvertencia = new char [256];
};

void agregarDato(Paciente*& pacientes, Paciente nuevoDato, int& tam) {
    tam++;
    Paciente* temp = new Paciente[tam];
    
    for (int i = 0; i < tam - 1; i++) {
        *(temp + i) = *(pacientes + i);
    }
    
    *(temp + tam - 1) = nuevoDato;
    
    delete[] pacientes;
    pacientes = temp;
}

void imprimirDatos(Paciente* pacientes, int tam) {
    for (int i = 0; i < tam; i++) {
        cout << "Paciente " << i + 1 << ": " << endl;
        cout << "Cedula: " << (pacientes + i)->cedula << endl;
        cout << "Mayor sistolica: " << (pacientes + i)->mayorSistolica << endl;
        cout << "Mayor diastolica: " << (pacientes + i)->mayorDiastolica << endl;
        cout << endl;
    }
}

Paciente* obtenerDatos(char* ruta, int& tam) {
    ifstream archivo (ruta);
    
    if (archivo.fail()) {
        cout << "No se pudo abrir el archivo " << ruta << ".";
        return nullptr;
    }
    
    Paciente* pacientes = nullptr;
    
    while (!archivo.eof()) {
        char linea[256];
        Paciente nuevoDato;
        int mayorDiastolica = 0;
        int menorDiastolica = 0;
        
        archivo.getline(linea, sizeof(linea));
        
        char* ptr = strtok(linea, ";");
        strcpy(nuevoDato.cedula, ptr);
        ptr = strtok(nullptr, "-");
        
        
        while (ptr != nullptr) {
            char* sistolica = new char[256];
            strcpy(sistolica, ptr);
            
            ptr = strtok(nullptr, ";");
            char* diastolica = new char[256];
            strcpy(diastolica, ptr);
            
            char* medida = strcat(sistolica, "-");
            medida = strcat(medida, diastolica);
            
            if (strcmp(sistolica, nuevoDato.mayorSistolica) > 0) {
                strcpy(nuevoDato.mayorSistolica, medida);
            }
            
            if (strcmp(diastolica, nuevoDato.mayorDiastolica) > 0) {
                strcpy(nuevoDato.mayorDiastolica, medida);
            }
            
            ptr = strtok(nullptr, "-");
        }
    
        agregarDato(pacientes, nuevoDato, tam);
    }
    
    return pacientes;
}

void escribirBinario(Paciente* pacientes, int tam) {
    ofstream binario("Pacientes.dat", ios::binary);
    for (int i = 0; i < tam; i++) {
        char* ptr = strtok((pacientes + i)->mayorSistolica, "-");
        int sistolica = atoi(ptr);
        
        char* ptr2 = strtok((pacientes + i)->mayorDiastolica, "-");
        ptr2 = strtok(nullptr, " ");
        int diastolica = atoi(ptr2);
        
        if (sistolica > 140 || diastolica > 95) {
            strcpy((pacientes + i)->mensajeAdvertencia, "ADVERTENCIA");
        } else if ((sistolica >= 130 && sistolica <= 140) || (diastolica >= 90 && diastolica <= 95)) {
            strcpy((pacientes + i)->mensajeAdvertencia, "SEGUIMIENTO");
        } else {
            strcpy((pacientes + i)->mensajeAdvertencia, "");
        }
        
        binario.write((char*)(pacientes + i), sizeof(Paciente));
    }
    binario.close();
}

int main()
{
    int tam = 0;
    char* ruta = new char[255];
    strcpy(ruta, "medidas.txt");
    Paciente* pacientes = obtenerDatos(ruta, tam);
    imprimirDatos(pacientes, tam);
    escribirBinario(pacientes, tam);
    return 0;
}