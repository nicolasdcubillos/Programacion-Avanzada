package aerolinea;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

// Parte A: encabezado, atributos, constructor con parámetros y métodos abstractos
public abstract class Vuelo implements Serializable {
    private static final long serialVersionUID = 1L;
    protected static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String origen;
    private String destino;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private int numeroVuelo;
    private float valor;
    private ArrayList<Pasajero> pasajeros;

    public Vuelo(String origen, String destino, LocalDate fechaInicial, LocalDate fechaFinal,
                 int numeroVuelo, float valor) {
        this.origen = origen;
        this.destino = destino;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.numeroVuelo = numeroVuelo;
        this.valor = valor;
        this.pasajeros = new ArrayList<>();
    }

    // Método abstracto: cada tipo de vuelo calcula su valor
    public abstract float calcularValor();

    // Parte descriptiva específica de cada subclase para el reporte
    public abstract String descripcionEspecifica();

    // Parte B: buscarPasajero
    public Pasajero buscarPasajero(String nombre) {
        for (Pasajero p : pasajeros) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    // Parte B: elimina los pasajeros menores de 18 años
    public void eliminarPasajerosMenoresDeEdad() {
        pasajeros.removeIf(p -> p.calcularEdad() < 18);
    }

    public void agregarPasajero(Pasajero pasajero) {
        pasajeros.add(pasajero);
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(int numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }
}
