package clinica;

public class PacienteExistenteException extends Exception {
    private static final long serialVersionUID = 1L;

    public PacienteExistenteException(String mensaje) {
        super(mensaje);
    }
}
