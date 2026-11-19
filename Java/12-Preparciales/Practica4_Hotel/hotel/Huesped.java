package hotel;

import java.io.Serializable;
import java.time.LocalDate;

public class Huesped implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int documento;
    private LocalDate fechaNacimiento;

    public Huesped(String nombre, int documento, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
