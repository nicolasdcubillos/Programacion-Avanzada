package restaurante;

public class IngredienteAgotadoException extends Exception {
    private static final long serialVersionUID = 1L;

    public IngredienteAgotadoException(String mensaje) {
        super(mensaje);
    }
}
