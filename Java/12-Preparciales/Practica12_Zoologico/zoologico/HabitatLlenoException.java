package zoologico;

public class HabitatLlenoException extends Exception {
    private static final long serialVersionUID = 1L;

    public HabitatLlenoException(String mensaje) {
        super(mensaje);
    }
}
