package hotel;

public class HabitacionOcupadaException extends Exception {
    private static final long serialVersionUID = 1L;

    public HabitacionOcupadaException(String mensaje) {
        super(mensaje);
    }
}
