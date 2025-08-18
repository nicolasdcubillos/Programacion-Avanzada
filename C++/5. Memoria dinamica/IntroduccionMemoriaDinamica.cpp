#include <iostream>
using namespace std;

int main() {
    int* ptr = new int;  // reserva memoria para un entero
    *ptr = 42;           // asignamos un valor

    cout << "Valor guardado en memoria dinamica: " << *ptr << endl;

    delete ptr;          // liberamos la memoria

    return 0;
}