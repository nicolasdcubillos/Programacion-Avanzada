package flota;

public class Bus extends Vehiculo {
    private static final long serialVersionUID = 1L;

    private int pasajeros;

    public Bus(String placa, int kilometraje, int pasajeros) {
        super(placa, kilometraje);
        this.pasajeros = pasajeros;
    }

    // Costo por km: 2000 + 150 por pasajero
    @Override
    public double calcularCostoViaje(int km) {
        return km * (2000 + 150 * pasajeros);
    }

    // Seguro: 1.500.000 + 10.000 por pasajero
    @Override
    public double calcularSeguro() {
        return 1500000 + 10000 * pasajeros;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }
}
