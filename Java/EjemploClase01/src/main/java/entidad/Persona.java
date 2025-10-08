package entidad;

public class Persona {
    private String nombre;
    private Integer edad;
    private Integer cedula;
    private Float altura;

    public Persona(String nombre, Integer edad, Integer cedula, Float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.altura = altura;
    }

    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void setNombre(String nombre ) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public String saludar() {
        return "Hola mi nombre es " + this.nombre + " y mi edad es " + this.edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", cedula=" + cedula +
                ", altura=" + altura +
                '}';
    }
}
