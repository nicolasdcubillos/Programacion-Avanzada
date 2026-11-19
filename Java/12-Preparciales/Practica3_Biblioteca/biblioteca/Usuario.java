package biblioteca;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String documento;
    private ArrayList<Libro> prestamos;

    public Usuario(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
        this.prestamos = new ArrayList<>();
    }

    // Suma las multas de todos los libros prestados si se entregan en fechaEntrega
    public int calcularMultaTotal(LocalDate fechaEntrega) {
        int total = 0;
        for (Libro libro : prestamos) {
            total += libro.calcularMulta(fechaEntrega);
        }
        return total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public ArrayList<Libro> getPrestamos() {
        return prestamos;
    }
}
