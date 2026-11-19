package robots;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        Arena arena = new Arena("Medellín", 30);
        try {
            arena.anadirRobot("volador");
            arena.anadirRobot("combate");
            arena.anadirRobot("combate");
            arena.anadirRobot("volador"); // 30 - 12 - 8 - 8 = 2 -> falla
        } catch (EnergiaInsuficienteException e) {
            System.out.println("Excepción: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        Robot volador = arena.getEquipo().get(0);
        volador.getObjetivos().add(arena.getEquipo().get(1));
        volador.getObjetivos().add(arena.getEquipo().get(2));
        volador.atacarObjetivos(); // 20 + 45 = 65 -> batería 35
        volador.atacarObjetivos(); // batería -30 -> se eliminan
        System.out.println("Objetivos restantes: " + volador.getObjetivos().size());
        System.out.println("Voladores poderosos: " + arena.cantidadVoladoresPoderosos());

        try {
            arena.guardarRobotsBinario("robots.dat");
            arena.guardarRobotsTexto("robots.txt");
            System.out.println("Archivos guardados");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
