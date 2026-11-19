package hotel;

public class HabitacionSencilla extends Habitacion {
    private static final long serialVersionUID = 1L;

    private boolean incluyeDesayuno;

    public HabitacionSencilla(int numero, TipoCama tipoCama, int precioNoche, boolean incluyeDesayuno) {
        super(numero, tipoCama, precioNoche);
        this.incluyeDesayuno = incluyeDesayuno;
    }

    @Override
    public int calcularCosto(int noches) {
        int costo = getPrecioNoche() * noches;
        if (incluyeDesayuno) {
            costo += 12000 * noches;
        }
        return costo;
    }

    public boolean isIncluyeDesayuno() {
        return incluyeDesayuno;
    }

    public void setIncluyeDesayuno(boolean incluyeDesayuno) {
        this.incluyeDesayuno = incluyeDesayuno;
    }
}
