package universidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Estudiante implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String codigo;
    private LocalDate fechaIngreso;
    private Modalidad modalidad;
    private ArrayList<Materia> materias;

    public Estudiante(String nombre, String codigo, LocalDate fechaIngreso, Modalidad modalidad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.fechaIngreso = fechaIngreso;
        this.modalidad = modalidad;
        this.materias = new ArrayList<>();
    }

    public abstract int calcularMatricula();

    // Promedio de las notas ponderado por los créditos de cada materia
    public double calcularPromedio() {
        int totalCreditos = 0;
        double suma = 0;
        for (Materia m : materias) {
            suma += m.getNota() * m.getCreditos();
            totalCreditos += m.getCreditos();
        }
        if (totalCreditos == 0) {
            return 0.0;
        }
        return suma / totalCreditos;
    }

    public int calcularTotalCreditos() {
        int total = 0;
        for (Materia m : materias) {
            total += m.getCreditos();
        }
        return total;
    }

    public void inscribirMateria(String nombreMateria, int creditos, double nota)
            throws CreditosExcedidosException, Exception {
        int maximo = 18;
        if (creditos <= 0) {
            throw new Exception("Los créditos de la materia deben ser positivos");
        }
        if (calcularTotalCreditos() + creditos > maximo) {
            throw new CreditosExcedidosException("Se superan los " + maximo
                    + " créditos permitidos al inscribir " + nombreMateria);
        }
        materias.add(new Materia(nombreMateria, creditos, nota));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }
}
