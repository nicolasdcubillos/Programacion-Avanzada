#include <iostream>
#include <cstring>  // strcmp
using namespace std;

int main() {
    char* palabra = new char[50];
    cout << "Ingresa una palabra: ";
    cin >> palabra;

    if (strcmp(palabra, "hola") == 0) {
        cout << "La palabra ingresada es exactamente 'hola'." << endl;
    } else {
        cout << "La palabra ingresada NO es 'hola'." << endl;
    }

    delete[] palabra;
    return 0;
}