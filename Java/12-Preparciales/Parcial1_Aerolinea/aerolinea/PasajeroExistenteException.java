package aerolinea;

// Excepción verificada (checked): extiende Exception
public class PasajeroExistenteException extends Exception {
    private static final long serialVersionUID = 1L;

    public PasajeroExistenteException(String mensaje) {
        super(mensaje);
    }
}
