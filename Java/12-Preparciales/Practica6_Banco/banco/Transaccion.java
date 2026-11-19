package banco;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaccion implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDate fecha;
    private TipoTransaccion tipo;
    private int monto;

    public Transaccion(TipoTransaccion tipo, int monto) {
        this.fecha = LocalDate.now();
        this.tipo = tipo;
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public TipoTransaccion getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransaccion tipo) {
        this.tipo = tipo;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}
