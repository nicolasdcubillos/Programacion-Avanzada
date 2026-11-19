package biblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibroDigital extends Libro {
    private static final long serialVersionUID = 1L;

    private int tamanoMb;

    public LibroDigital(String titulo, Genero genero, int tamanoMb) {
        super(titulo, genero);
        this.tamanoMb = tamanoMb;
    }

    // 300 por día de retraso, con un máximo de 3000
    @Override
    public int calcularMulta(LocalDate fechaEntrega) {
        long diasRetraso = ChronoUnit.DAYS.between(getFechaDevolucion(), fechaEntrega);
        if (diasRetraso <= 0) {
            return 0;
        }
        int multa = (int) diasRetraso * 300;
        if (multa > 3000) {
            multa = 3000;
        }
        return multa;
    }

    public int getTamanoMb() {
        return tamanoMb;
    }

    public void setTamanoMb(int tamanoMb) {
        this.tamanoMb = tamanoMb;
    }
}
