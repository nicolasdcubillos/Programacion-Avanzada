package restaurante;

public class PlatoFuerte extends Plato {
    private static final long serialVersionUID = 1L;

    private double adicion;

    public PlatoFuerte(String nombre, double precioBase, Categoria categoria, int ingredientes, double adicion) {
        super(nombre, precioBase, categoria, ingredientes);
        this.adicion = adicion;
    }

    // (precioBase + adicion) más una propina del 10%
    @Override
    public double calcularPrecioFinal() {
        double subtotal = getPrecioBase() + adicion;
        return subtotal + subtotal * 0.10;
    }

    public double getAdicion() {
        return adicion;
    }

    public void setAdicion(double adicion) {
        this.adicion = adicion;
    }
}
