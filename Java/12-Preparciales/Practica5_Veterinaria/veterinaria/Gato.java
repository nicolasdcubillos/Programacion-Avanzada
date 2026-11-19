package veterinaria;

import java.time.LocalDate;

public class Gato extends Mascota {
    private static final long serialVersionUID = 1L;

    private boolean esDeInterior;

    public Gato(String nombre, LocalDate fechaNacimiento, LocalDate ultimaVacuna,
            EstadoSalud estado, Dueno dueno, boolean esDeInterior) {
        super(nombre, fechaNacimiento, ultimaVacuna, estado, dueno);
        this.esDeInterior = esDeInterior;
    }

    // 35000; si NO es de interior se suman 10000; si el estado es CRITICO se suman 50000
    @Override
    public int calcularCostoConsulta() {
        int costo = 35000;
        if (!esDeInterior) {
            costo += 10000;
        }
        if (getEstado() == EstadoSalud.CRITICO) {
            costo += 50000;
        }
        return costo;
    }

    public boolean isEsDeInterior() {
        return esDeInterior;
    }

    public void setEsDeInterior(boolean esDeInterior) {
        this.esDeInterior = esDeInterior;
    }
}
