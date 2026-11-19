package cine;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public abstract class Funcion implements Serializable {
    private static final long serialVersionUID = 1L;

    private Pelicula pelicula;
    private String horario;
    private int precioBase;
    private int maxSillas;
    private ArrayList<Boleto> boletos;

    public Funcion(Pelicula pelicula, String horario, int precioBase, int maxSillas) {
        this.pelicula = pelicula;
        this.horario = horario;
        this.precioBase = precioBase;
        this.maxSillas = maxSillas;
        this.boletos = new ArrayList<>();
    }

    public abstract int calcularPrecio(LocalDate fechaNacimiento);

    // Menores de 12 años: 30% de descuento. Mayores o iguales a 60 años: 20% de descuento.
    public int aplicarDescuento(int precio, LocalDate fechaNacimiento) {
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        if (edad < 12) {
            return precio - precio * 30 / 100;
        }
        if (edad >= 60) {
            return precio - precio * 20 / 100;
        }
        return precio;
    }

    public int venderBoleto(int silla, Espectador espectador) throws SillaOcupadaException, Exception {
        if (silla < 1 || silla > maxSillas) {
            throw new Exception("La silla " + silla + " no existe en esta función");
        }
        for (Boleto b : boletos) {
            if (b.getSilla() == silla) {
                throw new SillaOcupadaException("La silla " + silla + " ya está ocupada");
            }
        }
        int precio = calcularPrecio(espectador.getFechaNacimiento());
        boletos.add(new Boleto(silla, precio, espectador));
        return precio;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

    public int getMaxSillas() {
        return maxSillas;
    }

    public void setMaxSillas(int maxSillas) {
        this.maxSillas = maxSillas;
    }

    public ArrayList<Boleto> getBoletos() {
        return boletos;
    }
}
