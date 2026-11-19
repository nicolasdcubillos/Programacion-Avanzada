package flota;

import java.io.Serializable;
import java.time.LocalDate;

public class Conductor implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String cedula;
    private LocalDate fechaNacimiento;
    private LocalDate vencimientoLicencia;

    public Conductor(String nombre, String cedula, LocalDate fechaNacimiento, LocalDate vencimientoLicencia) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.vencimientoLicencia = vencimientoLicencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getVencimientoLicencia() {
        return vencimientoLicencia;
    }

    public void setVencimientoLicencia(LocalDate vencimientoLicencia) {
        this.vencimientoLicencia = vencimientoLicencia;
    }
}
