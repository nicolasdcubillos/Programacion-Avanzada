package zoologico;

import java.time.LocalDate;

public class Mamifero extends Animal {
    private static final long serialVersionUID = 1L;

    private int numeroCrias;

    public Mamifero(String nombre, double pesoKg, LocalDate fechaNacimiento, LocalDate fechaIngreso, Dieta dieta,
            int numeroCrias) {
        super(nombre, pesoKg, fechaNacimiento, fechaIngreso, dieta);
        this.numeroCrias = numeroCrias;
    }

    @Override
    public double calcularCostoDiario() {
        return calcularCostoBase() + 10 * numeroCrias;
    }

    public int getNumeroCrias() {
        return numeroCrias;
    }

    public void setNumeroCrias(int numeroCrias) {
        this.numeroCrias = numeroCrias;
    }
}
