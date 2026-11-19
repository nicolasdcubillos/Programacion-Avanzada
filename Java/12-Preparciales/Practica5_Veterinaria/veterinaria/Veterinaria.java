package veterinaria;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class Veterinaria {
    private String nombre;
    private ArrayList<Mascota> mascotas;
    private ArrayList<Dueno> duenos;

    public Veterinaria(String nombre) {
        this.nombre = nombre;
        this.mascotas = new ArrayList<>();
        this.duenos = new ArrayList<>();
    }

    // Una mascota está repetida si ya existe otra con el mismo nombre y la misma cédula de dueño
    public void registrarMascota(Mascota nueva) throws MascotaYaRegistradaException {
        for (Mascota m : mascotas) {
            if (m.getNombre().equalsIgnoreCase(nueva.getNombre())
                    && m.getDueno().getCedula().equals(nueva.getDueno().getCedula())) {
                throw new MascotaYaRegistradaException("La mascota " + nueva.getNombre()
                        + " ya está registrada para el dueño " + nueva.getDueno().getNombre());
            }
        }
        mascotas.add(nueva);

        boolean duenoExiste = false;
        for (Dueno d : duenos) {
            if (d.getCedula().equals(nueva.getDueno().getCedula())) {
                duenoExiste = true;
            }
        }
        if (!duenoExiste) {
            duenos.add(nueva.getDueno());
        }
    }

    public int calcularCostoDueno(String cedula) throws Exception {
        boolean encontrado = false;
        for (Dueno d : duenos) {
            if (d.getCedula().equals(cedula)) {
                encontrado = true;
            }
        }
        if (!encontrado) {
            throw new Exception("No existe un dueño con la cédula " + cedula);
        }

        int total = 0;
        for (Mascota m : mascotas) {
            if (m.getDueno().getCedula().equals(cedula)) {
                total += m.calcularCostoConsulta();
            }
        }
        return total;
    }

    public int contarVacunasVencidas(LocalDate hoy) {
        int cantidad = 0;
        for (Mascota m : mascotas) {
            if (!m.estaVacunada(hoy)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    // Elimina las mascotas con edad estrictamente mayor a edadMaxima y retorna cuántas eliminó
    public int eliminarMascotasMayores(int edadMaxima, LocalDate hoy) {
        int eliminadas = 0;
        for (int i = mascotas.size() - 1; i >= 0; i--) {
            if (mascotas.get(i).calcularEdad(hoy) > edadMaxima) {
                mascotas.remove(i);
                eliminadas++;
            }
        }
        return eliminadas;
    }

    public void guardarMascotasBinario(String ruta) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {
            out.writeObject(mascotas);
        }
    }

    public void guardarMascotasTexto(String ruta) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Mascota m : mascotas) {
                String tipo;
                String adicional;
                if (m instanceof Perro) {
                    tipo = "Perro";
                    adicional = String.valueOf(((Perro) m).getPesoKg());
                } else {
                    tipo = "Gato";
                    if (((Gato) m).isEsDeInterior()) {
                        adicional = "Interior";
                    } else {
                        adicional = "Exterior";
                    }
                }
                bw.write("Tipo de mascota: " + tipo);
                bw.newLine();
                bw.write("Nombre: " + m.getNombre());
                bw.newLine();
                bw.write("Dueño: " + m.getDueno().getNombre());
                bw.newLine();
                bw.write("Fecha de nacimiento: " + m.getFechaNacimiento());
                bw.newLine();
                bw.write("Estado de salud: " + m.getEstado());
                bw.newLine();
                bw.write("Costo de consulta: " + m.calcularCostoConsulta());
                bw.newLine();
                bw.write("Valor adicional: " + adicional);
                bw.newLine();
                bw.newLine();
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public ArrayList<Dueno> getDuenos() {
        return duenos;
    }
}
