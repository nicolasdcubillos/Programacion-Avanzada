package hotel;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Habitacion implements Serializable {
    private static final long serialVersionUID = 1L;

    private int numero;
    private TipoCama tipoCama;
    private int precioNoche;
    private ArrayList<Reserva> reservas;

    public Habitacion(int numero, TipoCama tipoCama, int precioNoche) {
        this.numero = numero;
        this.tipoCama = tipoCama;
        this.precioNoche = precioNoche;
        this.reservas = new ArrayList<>();
    }

    public abstract int calcularCosto(int noches);

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoCama getTipoCama() {
        return tipoCama;
    }

    public void setTipoCama(TipoCama tipoCama) {
        this.tipoCama = tipoCama;
    }

    public int getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(int precioNoche) {
        this.precioNoche = precioNoche;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
}
