#include <iostream>
#include <string>
using namespace std;

int main() {
    string nombre;
    string comentario;

    cout << "Ingrese su nombre: ";
    cin >> nombre;  // Lee solo hasta el primer espacio

    // ¡Aquí queda un '\n' en el buffer!

    cout << "Ingrese un comentario: ";
    // getline intentará leer, pero encontrará el '\n' pendiente y terminará de inmediato
    // cin.ignore();
    getline(cin, comentario);

    cout << "Nombre: " << nombre << endl;
    cout << "Comentario: " << comentario << endl;

    return 0;
}
