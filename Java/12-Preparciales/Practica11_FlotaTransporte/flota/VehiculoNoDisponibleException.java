package flota;

public class VehiculoNoDisponibleException extends Exception {
    private static final long serialVersionUID = 1L;

    public VehiculoNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}
