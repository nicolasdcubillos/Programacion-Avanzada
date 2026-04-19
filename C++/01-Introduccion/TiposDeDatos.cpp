/*
 * TiposDeDatos.cpp
 * Tema: Tipos de datos, modificadores y tamaños en C++
 * 
 * Muestra los tipos de datos fundamentales, sus tamaños en memoria
 * y el uso de modificadores (signed, unsigned, short, long).
 */

#include <iostream>
#include <climits>   // Contiene los límites de los tipos enteros
#include <cfloat>    // Contiene los límites de los tipos flotantes

using namespace std;

int main() {
    // ===== TIPOS ENTEROS =====
    cout << "===== TIPOS ENTEROS =====" << endl;

    short s = 32767;
    int i = 2147483647;
    long l = 2147483647L;
    long long ll = 9223372036854775807LL;

    cout << "short:     valor = " << s  << ", tamaño = " << sizeof(short)     << " bytes" << endl;
    cout << "int:       valor = " << i  << ", tamaño = " << sizeof(int)       << " bytes" << endl;
    cout << "long:      valor = " << l  << ", tamaño = " << sizeof(long)      << " bytes" << endl;
    cout << "long long: valor = " << ll << ", tamaño = " << sizeof(long long) << " bytes" << endl;

    // ===== MODIFICADORES SIGNED / UNSIGNED =====
    cout << "\n===== SIGNED vs UNSIGNED =====" << endl;

    signed int si = -100;       // Permite valores negativos (por defecto)
    unsigned int ui = 4000000;  // Solo valores positivos, rango mayor

    cout << "signed int:   valor = " << si << ", rango: " << INT_MIN << " a " << INT_MAX << endl;
    cout << "unsigned int: valor = " << ui << ", rango: 0 a " << UINT_MAX << endl;

    // ===== TIPOS DE PUNTO FLOTANTE =====
    cout << "\n===== TIPOS FLOTANTES =====" << endl;

    float f = 3.14159f;
    double d = 3.141592653589793;
    long double ld = 3.141592653589793238L;

    cout << "float:       valor = " << f  << ", tamaño = " << sizeof(float)       << " bytes" << endl;
    cout << "double:      valor = " << d  << ", tamaño = " << sizeof(double)      << " bytes" << endl;
    cout << "long double: valor = " << ld << ", tamaño = " << sizeof(long double) << " bytes" << endl;

    // ===== TIPO CHAR =====
    cout << "\n===== TIPO CHAR =====" << endl;

    char c = 'A';
    cout << "char: valor = " << c << ", ASCII = " << (int)c << ", tamaño = " << sizeof(char) << " byte" << endl;

    // ===== TIPO BOOL =====
    cout << "\n===== TIPO BOOL =====" << endl;

    bool verdadero = true;
    bool falso = false;
    cout << "true  = " << verdadero << endl;
    cout << "false = " << falso << endl;
    cout << "tamaño = " << sizeof(bool) << " byte" << endl;

    // ===== CONSTANTES =====
    cout << "\n===== CONSTANTES =====" << endl;

    const double PI = 3.14159265358979;
    const int MAX_ESTUDIANTES = 30;
    cout << "PI = " << PI << endl;
    cout << "MAX_ESTUDIANTES = " << MAX_ESTUDIANTES << endl;
    // PI = 3.0;  // Error: no se puede modificar una constante

    return 0;
}
