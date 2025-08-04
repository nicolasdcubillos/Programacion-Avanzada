#include <iostream>
using namespace std;

int main() {
    char c;

    cout << "Ingresa un caracter: ";
    c = cin.peek();  // Mira el siguiente carácter sin extraerlo
    cout << "Con peek(), el siguiente carácter en el buffer es: '" << c << "'\n";

    if (isalpha(c)) {
        cout << "Es una letra. La devolvemos al buffer con putback().\n";
        cin.putback(c);  // Lo devuelve al flujo
    } else {
        cout << "No es una letra, así que lo dejamos como está.\n";
    }

    cout << "Ahora leemos con cin.get(): ";
    char nuevo;
    cin.get(nuevo);  // Lee el carácter (puede ser el mismo si fue devuelto)
    cout << "Carácter leído: '" << nuevo << "'\n";

    return 0;
}
