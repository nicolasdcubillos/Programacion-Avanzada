package profesores;

// 2.3 (el enunciado la llama ProfesorCatedar)
public class ProfesorCatedra extends Profesor {
    private int tarifa;
    private int horasDictadas;

    public ProfesorCatedra(String nombre, String correo, int tarifa, int horasDictadas) {
        super(nombre, correo);
        this.tarifa = tarifa;
        this.horasDictadas = horasDictadas;
    }

    @Override
    public String imprimirSalario() {
        return "Nombre: " + getNombre() + "\n"
                + "Correo: " + getCorreo() + "\n"
                + "Profesor de cátedra con tarifa de $" + tarifa + " por hora\n"
                + "Dicta " + horasDictadas + " al mes";
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public int getHorasDictadas() {
        return horasDictadas;
    }

    public void setHorasDictadas(int horasDictadas) {
        this.horasDictadas = horasDictadas;
    }
}
