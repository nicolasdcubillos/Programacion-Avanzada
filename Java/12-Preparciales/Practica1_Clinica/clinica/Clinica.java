package clinica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Clinica implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private ArrayList<Cita> citas;

    public Clinica(String nombre) {
        this.nombre = nombre;
        this.citas = new ArrayList<>();
    }

    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    public Cita buscarCita(int numeroCita) {
        for (Cita c : citas) {
            if (c.getNumeroCita() == numeroCita) {
                return c;
            }
        }
        return null;
    }

    public void agregarPaciente(int numeroCita, String nombre, int id, LocalDate fechaNacimiento,
                                int numeroTurno) throws PacienteExistenteException, Exception {
        Cita cita = buscarCita(numeroCita);
        if (cita == null) {
            throw new Exception("No existe la cita " + numeroCita);
        }
        if (cita.buscarPaciente(nombre) != null) {
            throw new PacienteExistenteException("El paciente " + nombre + " ya está en la cita " + numeroCita);
        }
        cita.agregarPaciente(new Paciente(nombre, id, fechaNacimiento, numeroTurno));
    }

    public ArrayList<String> citasConRequisito(String requisito) {
        ArrayList<String> resultado = new ArrayList<>();
        for (Cita c : citas) {
            if (c instanceof Especialista && ((Especialista) c).tieneRequisito(requisito)) {
                resultado.add(nombre + "-" + c.getNumeroCita() + "-" + c.getEspecialidad() + "-" + c.getMedico());
            }
        }
        return resultado;
    }

    public void generarReporte(String especialidad) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("reporteEspecialidad.txt"))) {
            for (Cita c : citas) {
                if (c.getEspecialidad().equalsIgnoreCase(especialidad)) {
                    String tipo = "Especialista";
                    if (c instanceof General) {
                        tipo = "General";
                    }
                    bw.write("<" + tipo + ">-<" + nombre + "-" + c.descripcionEspecifica() + ">");
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

    public ArrayList<Cita> getCitas() {
        return citas;
    }
}
