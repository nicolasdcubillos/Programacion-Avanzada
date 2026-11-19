package universidad;

import java.time.LocalDate;

public class EstudiantePregrado extends Estudiante {
    private static final long serialVersionUID = 1L;

    private String carrera;

    public EstudiantePregrado(String nombre, String codigo, LocalDate fechaIngreso, Modalidad modalidad,
            String carrera) {
        super(nombre, codigo, fechaIngreso, modalidad);
        this.carrera = carrera;
    }

    // Cada crédito inscrito cuesta 350000
    @Override
    public int calcularMatricula() {
        return calcularTotalCreditos() * 350000;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
