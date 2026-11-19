package estrategia;

public class RecursosInsuficientesException extends Exception {
    private static final long serialVersionUID = 1L;

    public RecursosInsuficientesException(String mensaje) {
        super(mensaje);
    }
}
