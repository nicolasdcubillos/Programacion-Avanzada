package zoologico;

import java.io.Serializable;
import java.util.ArrayList;

public class Habitat implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int capacidad;
    private ArrayList<Animal> animales;

    public Habitat(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.animales = new ArrayList<>();
    }

    public double calcularCostoDiario() {
        double total = 0;
        for (Animal a : animales) {
            total += a.calcularCostoDiario();
        }
        return total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public ArrayList<Animal> getAnimales() {
        return animales;
    }
}
