package restaurante;

import java.io.Serializable;

public abstract class Plato implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private double precioBase;
    private Categoria categoria;
    private int ingredientes;

    public Plato(String nombre, double precioBase, Categoria categoria, int ingredientes) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.categoria = categoria;
        this.ingredientes = ingredientes;
    }

    public abstract double calcularPrecioFinal();

    // Gasta una porción de ingredientes; si no quedan lanza la excepción propia
    public void preparar() throws IngredienteAgotadoException {
        if (ingredientes <= 0) {
            throw new IngredienteAgotadoException("No hay ingredientes para preparar " + nombre);
        }
        ingredientes--;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(int ingredientes) {
        this.ingredientes = ingredientes;
    }
}
