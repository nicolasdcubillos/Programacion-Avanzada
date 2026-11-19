package clinica;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class InterfazConsola {
    private Clinica clinica;

    public InterfazConsola(Clinica clinica) {
        this.clinica = clinica;
    }

    public void guardarClinica() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clinica.dat"))) {
            out.writeObject(clinica);
            System.out.println("Clínica guardada en clinica.dat");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Clinica clinica = new Clinica("SaludPlus");
        General g = new General("Medicina general", "Dra. Rojas", LocalDate.of(2025, 11, 20),
                LocalDate.of(2025, 11, 18), 101, 60000f, "Principal");
        Especialista e = new Especialista("Cardiologia", "Dr. Mejia", LocalDate.of(2025, 11, 22),
                LocalDate.of(2025, 11, 20), 102, 150000f, 40000);
        e.agregarRequisito(new RequisitoMedico("ayuno"));
        clinica.agregarCita(g);
        clinica.agregarCita(e);

        try {
            clinica.agregarPaciente(101, "Marta", 1, LocalDate.of(1950, 3, 2), 1);
            clinica.agregarPaciente(101, "Juan", 2, LocalDate.of(1990, 7, 9), 2);
            clinica.agregarPaciente(101, "Juan", 2, LocalDate.of(1990, 7, 9), 3); // repetido
        } catch (PacienteExistenteException ex) {
            System.out.println("Excepción: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        g.eliminarPacientesMayores();
        System.out.println("Pacientes tras eliminar mayores: " + g.getPacientes().size());
        System.out.println("Valor general: " + g.calcularValor());
        System.out.println("Valor especialista: " + e.calcularValor());
        System.out.println("Con ayuno: " + clinica.citasConRequisito("ayuno"));

        try {
            clinica.generarReporte("Cardiologia");
            System.out.println("Reporte generado en reporteEspecialidad.txt");
        } catch (IOException ex) {
            System.out.println("Error en reporte: " + ex.getMessage());
        }
        new InterfazConsola(clinica).guardarClinica();
    }
}
