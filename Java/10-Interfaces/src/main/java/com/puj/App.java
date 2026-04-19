package com.puj;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Vehiculo v1 = new Auto();
        Vehiculo v2 = new AutoElectrico();

        v1.acelerar();
        v1.frenar();

        v2.acelerar();
        v2.frenar();

        // Uso de instanceof y cast
        if (v2 instanceof Electrico) {
            ((Electrico) v2).cargarBateria();
        }
    }
}
