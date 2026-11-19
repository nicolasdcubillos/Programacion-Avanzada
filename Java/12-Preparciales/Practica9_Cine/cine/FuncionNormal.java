package cine;

import java.time.LocalDate;

public class FuncionNormal extends Funcion {
    private static final long serialVersionUID = 1L;

    public FuncionNormal(Pelicula pelicula, String horario, int precioBase, int maxSillas) {
        super(pelicula, horario, precioBase, maxSillas);
    }

    @Override
    public int calcularPrecio(LocalDate fechaNacimiento) {
        int precio = getPrecioBase() + getPelicula().getFormato().getRecargo();
        return aplicarDescuento(precio, fechaNacimiento);
    }
}
