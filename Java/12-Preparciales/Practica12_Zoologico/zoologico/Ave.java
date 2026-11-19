package zoologico;

import java.time.LocalDate;

public class Ave extends Animal implements Volador {
    private static final long serialVersionUID = 1L;

    private int alturaVuelo;

    public Ave(String nombre, double pesoKg, LocalDate fechaNacimiento, LocalDate fechaIngreso, Dieta dieta,
            int alturaVuelo) {
        super(nombre, pesoKg, fechaNacimiento, fechaIngreso, dieta);
        this.alturaVuelo = alturaVuelo;
    }

    @Override
    public double calcularCostoDiario() {
        double costo = calcularCostoBase();
        if (alturaVuelo > 100) {
            costo += 5;
        }
        return costo;
    }

    @Override
    public void volar() {
        alturaVuelo += 20;
    }

    @Override
    public int getAltura() {
        return alturaVuelo;
    }

    public int getAlturaVuelo() {
        return alturaVuelo;
    }

    public void setAlturaVuelo(int alturaVuelo) {
        this.alturaVuelo = alturaVuelo;
    }
}
