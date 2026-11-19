package zoologico;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private double pesoKg;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;
    private Dieta dieta;

    public Animal(String nombre, double pesoKg, LocalDate fechaNacimiento, LocalDate fechaIngreso, Dieta dieta) {
        this.nombre = nombre;
        this.pesoKg = pesoKg;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.dieta = dieta;
    }

    public abstract double calcularCostoDiario();

    public double calcularCostoBase() {
        double costoPorKg;
        if (dieta == Dieta.HERBIVORO) {
            costoPorKg = 2.0;
        } else if (dieta == Dieta.CARNIVORO) {
            costoPorKg = 5.0;
        } else {
            costoPorKg = 3.0;
        }
        return pesoKg * costoPorKg;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }
}
