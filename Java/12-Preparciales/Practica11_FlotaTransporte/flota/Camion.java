package flota;

public class Camion extends Vehiculo {
    private static final long serialVersionUID = 1L;

    private int toneladas;

    public Camion(String placa, int kilometraje, int toneladas) {
        super(placa, kilometraje);
        this.toneladas = toneladas;
    }

    // Costo por km: 3000 + 400 por tonelada. Si lleva más de 20 toneladas, el total se recarga un 10%
    @Override
    public double calcularCostoViaje(int km) {
        double costo = km * (3000 + 400 * toneladas);
        if (toneladas > 20) {
            costo = costo * 1.10;
        }
        return costo;
    }

    // Seguro: 2.000.000 + 50.000 por tonelada
    @Override
    public double calcularSeguro() {
        return 2000000 + 50000 * toneladas;
    }

    public int getToneladas() {
        return toneladas;
    }

    public void setToneladas(int toneladas) {
        this.toneladas = toneladas;
    }
}
