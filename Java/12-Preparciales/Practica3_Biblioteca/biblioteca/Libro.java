package biblioteca;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Libro implements Serializable {
    private static final long serialVersionUID = 1L;

    private String titulo;
    private Genero genero;
    private boolean disponible;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Libro(String titulo, Genero genero) {
        this.titulo = titulo;
        this.genero = genero;
        this.disponible = true;
        this.fechaPrestamo = null;
        this.fechaDevolucion = null;
    }

    // Calcula la multa si el libro (ya prestado) se entrega en fechaEntrega
    public abstract int calcularMulta(LocalDate fechaEntrega);

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
