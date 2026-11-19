package aerolinea;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Pasajero implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int id;
    private LocalDate fechaNacimiento;
    private int numSillas;

    public Pasajero(String nombre, int id, LocalDate fechaNacimiento, int numSillas) {
        this.nombre = nombre;
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.numSillas = numSillas;
    }

    // Edad en años cumplidos
    public int calcularEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getNumSillas() {
        return numSillas;
    }

    public void setNumSillas(int numSillas) {
        this.numSillas = numSillas;
    }
}
