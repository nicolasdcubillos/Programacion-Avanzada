/*
 * Conversiones.cpp
 * Tema: Conversión entre tipos de datos en C++
 * 
 * Muestra conversión implícita (automática) y explícita (casting)
 * entre diferentes tipos de datos.
 */

#include <iostream>

using namespace std;

int main() {
    // ===== CONVERSIÓN IMPLÍCITA (automática) =====
    cout << "===== CONVERSIÓN IMPLÍCITA =====" << endl;

    int entero = 10;
    double decimal = entero;  // int se convierte a double automáticamente
    cout << "int " << entero << " -> double " << decimal << endl;

    char letra = 'A';
    int ascii = letra;  // char se convierte a su valor ASCII
    cout << "char '" << letra << "' -> int " << ascii << endl;

    // Cuidado: se pierde información al convertir de mayor a menor
    double pi = 3.14159;
    int truncado = pi;  // Se pierde la parte decimal
    cout << "double " << pi << " -> int " << truncado << " (se pierde decimales)" << endl;

    // ===== CONVERSIÓN EXPLÍCITA (casting) =====
    cout << "\n===== CASTING EN C++ =====" << endl;

    // Casting estilo C
    double valor = 9.7;
    int resultado1 = (int)valor;
    cout << "(int)9.7 = " << resultado1 << endl;

    // Casting estilo C++ (recomendado)
    int resultado2 = static_cast<int>(valor);
    cout << "static_cast<int>(9.7) = " << resultado2 << endl;

    // ===== EJEMPLO PRÁCTICO: DIVISIÓN ENTERA vs DECIMAL =====
    cout << "\n===== DIVISIÓN ENTERA vs DECIMAL =====" << endl;

    int a = 7, b = 2;
    cout << "7 / 2 (enteros)            = " << a / b << endl;                          // Resultado: 3
    cout << "7.0 / 2 (un double)        = " << 7.0 / b << endl;                        // Resultado: 3.5
    cout << "(double)7 / 2 (con cast)   = " << static_cast<double>(a) / b << endl;     // Resultado: 3.5
    cout << "7 % 2 (módulo)             = " << a % b << endl;                           // Residuo: 1

    // ===== CONVERSIÓN ENTRE CHAR E INT =====
    cout << "\n===== CONVERSIÓN CHAR <-> INT =====" << endl;

    for (char c = 'A'; c <= 'Z'; c++) {
        cout << c << "=" << (int)c << " ";
    }
    cout << endl;

    // Convertir un dígito char a su valor numérico
    char digito = '7';
    int numero = digito - '0';  // Truco: restar '0' para obtener el valor
    cout << "char '7' - '0' = int " << numero << endl;

    return 0;
}
