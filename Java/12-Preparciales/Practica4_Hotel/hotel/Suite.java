package hotel;

public class Suite extends Habitacion {
    private static final long serialVersionUID = 1L;

    private boolean jacuzzi;
    private int serviciosIncluidos;

    public Suite(int numero, TipoCama tipoCama, int precioNoche, boolean jacuzzi, int serviciosIncluidos) {
        super(numero, tipoCama, precioNoche);
        this.jacuzzi = jacuzzi;
        this.serviciosIncluidos = serviciosIncluidos;
    }

    @Override
    public int calcularCosto(int noches) {
        int costo = (getPrecioNoche() + serviciosIncluidos * 15000) * noches;
        if (jacuzzi) {
            costo += 40000;
        }
        return costo;
    }

    public boolean isJacuzzi() {
        return jacuzzi;
    }

    public void setJacuzzi(boolean jacuzzi) {
        this.jacuzzi = jacuzzi;
    }

    public int getServiciosIncluidos() {
        return serviciosIncluidos;
    }

    public void setServiciosIncluidos(int serviciosIncluidos) {
        this.serviciosIncluidos = serviciosIncluidos;
    }
}
