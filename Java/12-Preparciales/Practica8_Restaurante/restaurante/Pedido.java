package restaurante;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido implements Serializable, Descontable {
    private static final long serialVersionUID = 1L;

    private String cliente;
    private LocalDate fecha;
    private ArrayList<Plato> platos;

    public Pedido(String cliente, LocalDate fecha) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.platos = new ArrayList<>();
    }

    // Con 4 o más platos el pedido tiene un 10% de descuento
    @Override
    public double aplicarDescuento(double valor) {
        if (platos.size() >= 4) {
            return valor - valor * 0.10;
        }
        return valor;
    }

    public double calcularTotal() {
        double suma = 0;
        for (Plato p : platos) {
            suma += p.calcularPrecioFinal();
        }
        return aplicarDescuento(suma);
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }
}
