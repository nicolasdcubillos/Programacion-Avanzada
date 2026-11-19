package profesores;

public class App {
    public static void main(String[] args) {
        Nomina nomina = new Nomina();
        nomina.agregarProfesorPlanta("Ana Gómez", "ana@puj.edu.co", "Titular", 9000000);
        nomina.agregarProfesorCatedra("Luis Pérez", "luis@puj.edu.co", 80000, 40);
        nomina.agregarProfesorCatedra("Eva Ruiz", "eva@puj.edu.co", 75000, 32);
        nomina.eliminarProfesor("eva@puj.edu.co");
        for (String s : nomina.imprimirNomina()) {
            System.out.println(s);
            System.out.println();
        }
    }
}
