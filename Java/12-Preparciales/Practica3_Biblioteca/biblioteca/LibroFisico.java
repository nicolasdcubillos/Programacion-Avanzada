package biblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibroFisico extends Libro {
    private static final long serialVersionUID = 1L;

    private int numeroPaginas;

    public LibroFisico(String titulo, Genero genero, int numeroPaginas) {
        super(titulo, genero);
        this.numeroPaginas = numeroPaginas;
    }

    // 1000 por día de retraso; si hay retraso y tiene más de 500 páginas, recargo fijo de 2000
    @Override
    public int calcularMulta(LocalDate fechaEntrega) {
        long diasRetraso = ChronoUnit.DAYS.between(getFechaDevolucion(), fechaEntrega);
        if (diasRetraso <= 0) {
            return 0;
        }
        int multa = (int) diasRetraso * 1000;
        if (numeroPaginas > 500) {
            multa += 2000;
        }
        return multa;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
}
