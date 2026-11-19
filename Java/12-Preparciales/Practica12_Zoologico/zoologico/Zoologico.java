package zoologico;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Zoologico {
    private String nombre;
    private ArrayList<Habitat> habitats;
    private ArrayList<Cuidador> cuidadores;

    public Zoologico(String nombre) {
        this.nombre = nombre;
        this.habitats = new ArrayList<>();
        this.cuidadores = new ArrayList<>();
    }

    public void agregarAnimal(String nombreHabitat, Animal animal) throws HabitatLlenoException, Exception {
        Habitat encontrado = null;
        for (Habitat h : habitats) {
            if (h.getNombre().equalsIgnoreCase(nombreHabitat)) {
                encontrado = h;
            }
        }
        if (encontrado == null) {
            throw new Exception("No existe el hábitat: " + nombreHabitat);
        }
        if (encontrado.getAnimales().size() >= encontrado.getCapacidad()) {
            throw new HabitatLlenoException("El hábitat " + nombreHabitat + " está lleno");
        }
        encontrado.getAnimales().add(animal);
    }

    public int contarAnimalesPorDieta(Dieta dieta) {
        int cantidad = 0;
        for (Habitat h : habitats) {
            for (Animal a : h.getAnimales()) {
                if (a.getDieta() == dieta) {
                    cantidad++;
                }
            }
        }
        return cantidad;
    }

    public int eliminarAnimalesMayores(int anios, LocalDate fechaActual) {
        int eliminados = 0;
        for (Habitat h : habitats) {
            ArrayList<Animal> animales = h.getAnimales();
            for (int i = animales.size() - 1; i >= 0; i--) {
                int edad = Period.between(animales.get(i).getFechaNacimiento(), fechaActual).getYears();
                if (edad > anios) {
                    animales.remove(i);
                    eliminados++;
                }
            }
        }
        return eliminados;
    }

    public void guardarAnimalesBinario(String ruta) throws IOException {
        ArrayList<Animal> todos = new ArrayList<>();
        for (Habitat h : habitats) {
            for (Animal a : h.getAnimales()) {
                todos.add(a);
            }
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {
            out.writeObject(todos);
        }
    }

    public void guardarAnimalesTexto(String ruta) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Habitat h : habitats) {
                for (Animal a : h.getAnimales()) {
                    String tipo;
                    if (a instanceof Ave) {
                        tipo = "Ave";
                    } else {
                        tipo = "Mamífero";
                    }
                    bw.write("Hábitat: " + h.getNombre());
                    bw.newLine();
                    bw.write("Tipo: " + tipo);
                    bw.newLine();
                    bw.write("Nombre: " + a.getNombre());
                    bw.newLine();
                    bw.write("Dieta: " + a.getDieta());
                    bw.newLine();
                    bw.write("Peso: " + a.getPesoKg());
                    bw.newLine();
                    bw.write("Costo diario: " + a.calcularCostoDiario());
                    bw.newLine();
                    bw.newLine();
                }
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Habitat> getHabitats() {
        return habitats;
    }

    public ArrayList<Cuidador> getCuidadores() {
        return cuidadores;
    }
}
