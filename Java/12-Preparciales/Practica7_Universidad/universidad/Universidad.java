package universidad;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Universidad {
    private String nombre;
    private ArrayList<Estudiante> estudiantes;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    public int contarEstudiantesDestacados() {
        int cantidad = 0;
        for (Estudiante e : estudiantes) {
            if (e.calcularPromedio() > 4.0) {
                cantidad++;
            }
        }
        return cantidad;
    }

    // Elimina a los estudiantes con promedio menor a 3.0 y retorna cuántos eliminó
    public int eliminarEstudiantesBajoRendimiento() {
        int eliminados = 0;
        for (int i = estudiantes.size() - 1; i >= 0; i--) {
            if (estudiantes.get(i).calcularPromedio() < 3.0) {
                estudiantes.remove(i);
                eliminados++;
            }
        }
        return eliminados;
    }

    public void guardarEstudiantesBinario(String ruta) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {
            out.writeObject(estudiantes);
        }
    }

    public void guardarEstudiantesTexto(String ruta) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Estudiante e : estudiantes) {
                String tipo;
                if (e instanceof EstudiantePregrado) {
                    tipo = "Pregrado";
                } else {
                    tipo = "Posgrado";
                }
                double promedio = Math.round(e.calcularPromedio() * 100) / 100.0;
                bw.write("Tipo de estudiante: " + tipo);
                bw.newLine();
                bw.write("Nombre: " + e.getNombre());
                bw.newLine();
                bw.write("Fecha de ingreso: " + e.getFechaIngreso());
                bw.newLine();
                bw.write("Modalidad: " + e.getModalidad());
                bw.newLine();
                bw.write("Promedio: " + promedio);
                bw.newLine();
                bw.write("Matrícula: " + e.calcularMatricula());
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

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}
