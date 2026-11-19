package universidad;

import java.io.Serializable;

public class Materia implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int creditos;
    private double nota;

    public Materia(String nombre, int creditos, double nota) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
