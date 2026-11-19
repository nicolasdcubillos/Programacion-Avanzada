package cine;

import java.io.Serializable;

public class Pelicula implements Serializable {
    private static final long serialVersionUID = 1L;

    private String titulo;
    private int duracionMinutos;
    private Formato formato;

    public Pelicula(String titulo, int duracionMinutos, Formato formato) {
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
        this.formato = formato;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }
}
