package cine;

import java.time.LocalDate;

public class FuncionVip extends Funcion {
    private static final long serialVersionUID = 1L;

    private int recargoVip;

    public FuncionVip(Pelicula pelicula, String horario, int precioBase, int maxSillas, int recargoVip) {
        super(pelicula, horario, precioBase, maxSillas);
        this.recargoVip = recargoVip;
    }

    @Override
    public int calcularPrecio(LocalDate fechaNacimiento) {
        int precio = getPrecioBase() + getPelicula().getFormato().getRecargo() + recargoVip;
        return aplicarDescuento(precio, fechaNacimiento);
    }

    public int getRecargoVip() {
        return recargoVip;
    }

    public void setRecargoVip(int recargoVip) {
        this.recargoVip = recargoVip;
    }
}
