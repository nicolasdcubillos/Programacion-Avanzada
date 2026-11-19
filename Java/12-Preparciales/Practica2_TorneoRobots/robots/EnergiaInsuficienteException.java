package robots;

public class EnergiaInsuficienteException extends Exception {
    private static final long serialVersionUID = 1L;

    public EnergiaInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
