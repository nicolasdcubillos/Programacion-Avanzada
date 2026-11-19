package veterinaria;

import java.time.LocalDate;

public class Perro extends Mascota {
    private static final long serialVersionUID = 1L;

    private int pesoKg;

    public Perro(String nombre, LocalDate fechaNacimiento, LocalDate ultimaVacuna,
            EstadoSalud estado, Dueno dueno, int pesoKg) {
        super(nombre, fechaNacimiento, ultimaVacuna, estado, dueno);
        this.pesoKg = pesoKg;
    }

    // 40000 + 1000 por cada kg de peso; si el estado es CRITICO se suman 50000
    @Override
    public int calcularCostoConsulta() {
        int costo = 40000 + 1000 * pesoKg;
        if (getEstado() == EstadoSalud.CRITICO) {
            costo += 50000;
        }
        return costo;
    }

    public int getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(int pesoKg) {
        this.pesoKg = pesoKg;
    }
}
