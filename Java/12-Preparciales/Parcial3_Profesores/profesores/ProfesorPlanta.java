package profesores;

// 2.2
public class ProfesorPlanta extends Profesor {
    private String categoria; // Asistente, Asociado o Titular
    private int salario;

    public ProfesorPlanta(String nombre, String correo, String categoria, int salario) {
        super(nombre, correo);
        this.categoria = categoria;
        this.salario = salario;
    }

    @Override
    public String imprimirSalario() {
        return "Nombre: " + getNombre() + "\n"
                + "Correo: " + getCorreo() + "\n"
                + "Profesor de planta en categoría " + categoria + "\n"
                + "Salario: $" + salario + " mensual";
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
}
