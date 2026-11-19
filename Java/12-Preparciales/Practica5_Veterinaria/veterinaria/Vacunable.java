package veterinaria;

import java.time.LocalDate;

public interface Vacunable {
    void aplicarVacuna(LocalDate fecha) throws Exception;

    boolean estaVacunada(LocalDate hoy);
}
