package universidad;

public class CreditosExcedidosException extends Exception {
    private static final long serialVersionUID = 1L;

    public CreditosExcedidosException(String mensaje) {
        super(mensaje);
    }
}
