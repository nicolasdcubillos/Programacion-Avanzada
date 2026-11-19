package clinica;

import java.time.LocalDate;

public class General extends Cita {
    private static final long serialVersionUID = 1L;

    private String tipoSede; // "Principal", "Norte" o "Satélite"

    public General(String especialidad, String medico, LocalDate fechaCita, LocalDate fechaLimitePago,
                   int numeroCita, float valor, String tipoSede) {
        super(especialidad, medico, fechaCita, fechaLimitePago, numeroCita, valor);
        this.tipoSede = tipoSede;
    }

    @Override
    public float calcularValor() {
        float incremento;
        switch (tipoSede) {
            case "Principal":
                incremento = 0.15f;
                break;
            case "Norte":
                incremento = 0.08f;
                break;
            case "Satélite":
                incremento = 0.03f;
                break;
            default:
                incremento = 0f;
        }
        return getValor() * (1 + incremento);
    }

    @Override
    public String descripcionEspecifica() {
        return getNumeroCita() + "-" + getEspecialidad() + "-" + getMedico() + "-"
                + getFechaCita().format(FORMATO) + "-" + (long) getValor() + "-" + tipoSede;
    }

    public String getTipoSede() {
        return tipoSede;
    }

    public void setTipoSede(String tipoSede) {
        this.tipoSede = tipoSede;
    }
}
