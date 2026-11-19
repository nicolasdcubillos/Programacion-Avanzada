package clinica;

import java.time.LocalDate;
import java.util.ArrayList;

public class Especialista extends Cita {
    private static final long serialVersionUID = 1L;

    private int recargo;
    private ArrayList<RequisitoMedico> requisitos;

    public Especialista(String especialidad, String medico, LocalDate fechaCita, LocalDate fechaLimitePago,
                        int numeroCita, float valor, int recargo) {
        super(especialidad, medico, fechaCita, fechaLimitePago, numeroCita, valor);
        this.recargo = recargo;
        this.requisitos = new ArrayList<>();
    }

    @Override
    public float calcularValor() {
        return getValor() + recargo;
    }

    @Override
    public String descripcionEspecifica() {
        return getNumeroCita() + "-" + getEspecialidad() + "-" + getMedico() + "-"
                + getFechaCita().format(FORMATO) + "-" + (long) getValor() + "-" + recargo;
    }

    public boolean tieneRequisito(String descripcion) {
        for (RequisitoMedico r : requisitos) {
            if (r.getDescripcion().equalsIgnoreCase(descripcion)) {
                return true;
            }
        }
        return false;
    }

    public void agregarRequisito(RequisitoMedico requisito) {
        requisitos.add(requisito);
    }

    public int getRecargo() {
        return recargo;
    }

    public void setRecargo(int recargo) {
        this.recargo = recargo;
    }

    public ArrayList<RequisitoMedico> getRequisitos() {
        return requisitos;
    }
}
