package reino;

public class ManaInsuficienteException extends Exception {
    private static final long serialVersionUID = 1L;

    public ManaInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
