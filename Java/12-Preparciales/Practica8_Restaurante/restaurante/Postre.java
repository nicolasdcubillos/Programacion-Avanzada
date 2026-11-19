package restaurante;

public class Postre extends Plato implements Descontable {
    private static final long serialVersionUID = 1L;

    private int porcentajeDescuento;

    public Postre(String nombre, double precioBase, Categoria categoria, int ingredientes, int porcentajeDescuento) {
        super(nombre, precioBase, categoria, ingredientes);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double aplicarDescuento(double valor) {
        return valor - valor * porcentajeDescuento / 100;
    }

    @Override
    public double calcularPrecioFinal() {
        return aplicarDescuento(getPrecioBase());
    }

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(int porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
}
