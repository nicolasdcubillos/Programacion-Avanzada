package aerolinea;

import java.time.LocalDate;
import java.util.ArrayList;

public class Internacional extends Vuelo {
    private static final long serialVersionUID = 1L;

    private int impuesto;
    private ArrayList<RequisitosMigratorio> requisitos;

    public Internacional(String origen, String destino, LocalDate fechaInicial, LocalDate fechaFinal,
                         int numeroVuelo, float valor, int impuesto) {
        super(origen, destino, fechaInicial, fechaFinal, numeroVuelo, valor);
        this.impuesto = impuesto;
        this.requisitos = new ArrayList<>();
    }

    // El valor del vuelo se incrementa con el impuesto
    @Override
    public float calcularValor() {
        return getValor() + impuesto;
    }

    @Override
    public String descripcionEspecifica() {
        return getFechaInicial().format(FORMATO) + "-" + getFechaFinal().format(FORMATO)
                + "-" + (long) getValor() + "-" + impuesto;
    }

    public boolean tieneRequisito(String descripcion) {
        for (RequisitosMigratorio r : requisitos) {
            if (r.getDescripcion().equalsIgnoreCase(descripcion)) {
                return true;
            }
        }
        return false;
    }

    public void agregarRequisito(RequisitosMigratorio requisito) {
        requisitos.add(requisito);
    }

    public int getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }

    public ArrayList<RequisitosMigratorio> getRequisitos() {
        return requisitos;
    }
}
