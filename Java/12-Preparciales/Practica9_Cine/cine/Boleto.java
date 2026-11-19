package cine;

import java.io.Serializable;

public class Boleto implements Serializable {
    private static final long serialVersionUID = 1L;

    private int silla;
    private int precio;
    private Espectador espectador;

    public Boleto(int silla, int precio, Espectador espectador) {
        this.silla = silla;
        this.precio = precio;
        this.espectador = espectador;
    }

    public int getSilla() {
        return silla;
    }

    public void setSilla(int silla) {
        this.silla = silla;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }
}
