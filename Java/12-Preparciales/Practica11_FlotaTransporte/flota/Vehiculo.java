package flota;

import java.io.Serializable;

public abstract class Vehiculo implements Serializable, Asegurable {
    private static final long serialVersionUID = 1L;

    private String placa;
    private int kilometraje;
    private Estado estado;
    private Conductor conductor;

    public Vehiculo(String placa, int kilometraje) {
        this.placa = placa;
        this.kilometraje = kilometraje;
        this.estado = Estado.DISPONIBLE;
        this.conductor = null;
    }

    public abstract double calcularCostoViaje(int km);

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
}
