package veterinaria;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public abstract class Mascota implements Vacunable, Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private LocalDate fechaNacimiento;
    private LocalDate ultimaVacuna;
    private EstadoSalud estado;
    private Dueno dueno;

    public Mascota(String nombre, LocalDate fechaNacimiento, LocalDate ultimaVacuna,
            EstadoSalud estado, Dueno dueno) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.ultimaVacuna = ultimaVacuna;
        this.estado = estado;
        this.dueno = dueno;
    }

    public abstract int calcularCostoConsulta();

    // Años cumplidos a la fecha "hoy"
    public int calcularEdad(LocalDate hoy) {
        return Period.between(fechaNacimiento, hoy).getYears();
    }

    // La nueva fecha no puede ser anterior a la última vacuna registrada
    @Override
    public void aplicarVacuna(LocalDate fecha) throws Exception {
        if (fecha.isBefore(ultimaVacuna)) {
            throw new Exception("La fecha de vacunación es anterior a la última vacuna de " + nombre);
        }
        ultimaVacuna = fecha;
    }

    // La vacuna está vigente si no ha pasado más de un año desde la última aplicada
    @Override
    public boolean estaVacunada(LocalDate hoy) {
        return !hoy.isAfter(ultimaVacuna.plusYears(1));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getUltimaVacuna() {
        return ultimaVacuna;
    }

    public void setUltimaVacuna(LocalDate ultimaVacuna) {
        this.ultimaVacuna = ultimaVacuna;
    }

    public EstadoSalud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSalud estado) {
        this.estado = estado;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }
}
