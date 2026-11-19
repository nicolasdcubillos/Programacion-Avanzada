package biblioteca;

public class LibroNoDisponibleException extends Exception {
    private static final long serialVersionUID = 1L;

    public LibroNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}
