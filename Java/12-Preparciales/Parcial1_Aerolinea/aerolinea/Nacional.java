package aerolinea;

import java.time.LocalDate;

public class Nacional extends Vuelo {
    private static final long serialVersionUID = 1L;

    private String tipoAeropuerto; // "Grande", "Mediano" o "Pequeño"

    public Nacional(String origen, String destino, LocalDate fechaInicial, LocalDate fechaFinal,
                    int numeroVuelo, float valor, String tipoAeropuerto) {
        super(origen, destino, fechaInicial, fechaFinal, numeroVuelo, valor);
        this.tipoAeropuerto = tipoAeropuerto;
    }

    // Grande +20%, Mediano +10%, Pequeño +5%
    @Override
    public float calcularValor() {
        float incremento;
        switch (tipoAeropuerto) {
            case "Grande":
                incremento = 0.20f;
                break;
            case "Mediano":
                incremento = 0.10f;
                break;
            case "Pequeño":
                incremento = 0.05f;
                break;
            default:
                incremento = 0f;
        }
        return getValor() * (1 + incremento);
    }

    @Override
    public String descripcionEspecifica() {
        return getFechaInicial().format(FORMATO) + "-" + getFechaFinal().format(FORMATO)
                + "-" + (long) getValor() + "-" + tipoAeropuerto;
    }

    public String getTipoAeropuerto() {
        return tipoAeropuerto;
    }

    public void setTipoAeropuerto(String tipoAeropuerto) {
        this.tipoAeropuerto = tipoAeropuerto;
    }
}
