package entidad;


class Animal {
    public void sonido() {
        System.out.println("El animal hace un sonido");
    }
}

class Perro extends Animal {
    @Override
    public void sonido() {
        System.out.println("El perro ladra");
    }
}



public class Persona {
    private final String pais = "Colombia";
    private static Integer contador;


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



    public Persona() {
        nombre = "Sin nombre";
        edad = 0;
    }

    public void mostrarDatos() {
        System.out.println(nombre + " tiene " + edad + " años");
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

    public final void imprimirInfo() {
        System.out.println("Información general");
    }

    public void saludar(String nombre) {
        System.out.println("Hola " + nombre + "!" + "mi nombre es " +  this.nombre);
    }

    public static void mostrarContador() {
        System.out.println("Objetos creados: " + contador);
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
