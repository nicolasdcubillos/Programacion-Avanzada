package universidad;

import java.time.LocalDate;

public class EstudiantePosgrado extends Estudiante {
    private static final long serialVersionUID = 1L;

    private String lineaInvestigacion;

    public EstudiantePosgrado(String nombre, String codigo, LocalDate fechaIngreso, Modalidad modalidad,
            String lineaInvestigacion) {
        super(nombre, codigo, fechaIngreso, modalidad);
        this.lineaInvestigacion = lineaInvestigacion;
    }

    // Cada crédito cuesta 500000 más un recargo fijo de 1200000
    @Override
    public int calcularMatricula() {
        return calcularTotalCreditos() * 500000 + 1200000;
    }

    public String getLineaInvestigacion() {
        return lineaInvestigacion;
    }

    public void setLineaInvestigacion(String lineaInvestigacion) {
        this.lineaInvestigacion = lineaInvestigacion;
    }
}
