package estrategia;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        Region region = new Region("Valoria", 22);
        try {
            region.añadirPersonaje("dragon");
            region.añadirPersonaje("soldado");
            region.añadirPersonaje("soldado");
            region.añadirPersonaje("dragon"); // 22 - 10 - 5 - 5 = 2 -> falla
        } catch (RecursosInsuficientesException e) {
            System.out.println("Excepción: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        Personaje dragon = region.getEjercito().get(0);
        Personaje soldado = region.getEjercito().get(1);
        dragon.getObjetivos().add(soldado);
        dragon.getObjetivos().add(region.getEjercito().get(2));
        dragon.atacarObjetivos(); // 30 + 60 = 90 de daño a cada soldado (vida 100 -> 10)
        dragon.atacarObjetivos(); // vida -80 -> se eliminan de la lista de objetivos
        System.out.println("Objetivos restantes: " + dragon.getObjetivos().size());
        System.out.println("Dragones poderosos: " + region.cantidadDragonesPoderosos());

        try {
            region.guardarPersonajesBinario("personajes.dat");
            region.guardarPersonajesTexto("personajes.txt");
            System.out.println("Archivos guardados");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
