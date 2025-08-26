#include <iostream>
#include <cstring>  // strlen
using namespace std;

int main() {
    char* palabra = new char[50];

    cout << "Ingresa una palabra: ";
    cin >> palabra;

    cout << "La palabra '" << palabra << "' tiene " << strlen(palabra) << " caracteres." << endl;

    delete[] palabra;
    return 0;
}
