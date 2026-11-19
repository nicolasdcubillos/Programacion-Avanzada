package cine;

import java.io.Serializable;
import java.time.LocalDate;

public class Espectador implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private LocalDate fechaNacimiento;

    public Espectador(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
