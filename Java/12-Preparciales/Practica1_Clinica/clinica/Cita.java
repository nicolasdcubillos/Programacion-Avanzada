package clinica;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Cita implements Serializable {
    private static final long serialVersionUID = 1L;
    protected static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String especialidad;
    private String medico;
    private LocalDate fechaCita;
    private LocalDate fechaLimitePago;
    private int numeroCita;
    private float valor;
    private ArrayList<Paciente> pacientes;

    public Cita(String especialidad, String medico, LocalDate fechaCita, LocalDate fechaLimitePago,
                int numeroCita, float valor) {
        this.especialidad = especialidad;
        this.medico = medico;
        this.fechaCita = fechaCita;
        this.fechaLimitePago = fechaLimitePago;
        this.numeroCita = numeroCita;
        this.valor = valor;
        this.pacientes = new ArrayList<>();
    }

    public abstract float calcularValor();

    public abstract String descripcionEspecifica();

    public Paciente buscarPaciente(String nombre) {
        for (Paciente p : pacientes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public void eliminarPacientesMayores() {
        pacientes.removeIf(p -> p.calcularEdad() >= 65);
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public LocalDate getFechaLimitePago() {
        return fechaLimitePago;
    }

    public void setFechaLimitePago(LocalDate fechaLimitePago) {
        this.fechaLimitePago = fechaLimitePago;
    }

    public int getNumeroCita() {
        return numeroCita;
    }

    public void setNumeroCita(int numeroCita) {
        this.numeroCita = numeroCita;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
}
