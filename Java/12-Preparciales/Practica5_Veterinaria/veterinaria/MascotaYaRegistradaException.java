package veterinaria;

public class MascotaYaRegistradaException extends Exception {
    private static final long serialVersionUID = 1L;

    public MascotaYaRegistradaException(String mensaje) {
        super(mensaje);
    }
}
