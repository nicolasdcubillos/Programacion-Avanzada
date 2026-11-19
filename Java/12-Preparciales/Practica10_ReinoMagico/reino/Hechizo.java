package reino;

import java.io.Serializable;

public class Hechizo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int poder;

    public Hechizo(String nombre, int poder) {
        this.nombre = nombre;
        this.poder = poder;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }
}
