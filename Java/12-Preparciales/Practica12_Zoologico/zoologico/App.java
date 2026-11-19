package zoologico;

import java.io.IOException;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Zoologico zoo = new Zoologico("Zoológico de Cali");
        zoo.getHabitats().add(new Habitat("Sabana", 3));
        zoo.getHabitats().add(new Habitat("Aviario", 2));
        zoo.getCuidadores().add(new Cuidador("Marta Ruiz", "1001", 2500000));

        LocalDate hoy = LocalDate.of(2026, 11, 19);
        Mamifero leon = new Mamifero("León", 190, LocalDate.of(2018, 3, 10), LocalDate.of(2019, 1, 5),
                Dieta.CARNIVORO, 2);
        Mamifero cebra = new Mamifero("Cebra", 300, LocalDate.of(2020, 6, 1), LocalDate.of(2021, 2, 1),
                Dieta.HERBIVORO, 0);
        Mamifero elefante = new Mamifero("Elefante", 4000, LocalDate.of(1990, 8, 15), LocalDate.of(1995, 5, 20),
                Dieta.HERBIVORO, 1);
        Mamifero jirafa = new Mamifero("Jirafa", 800, LocalDate.of(2022, 4, 4), LocalDate.of(2022, 9, 9),
                Dieta.HERBIVORO, 0);
        Ave condor = new Ave("Cóndor", 12, LocalDate.of(2015, 12, 25), LocalDate.of(2016, 3, 3),
                Dieta.CARNIVORO, 150);
        Ave loro = new Ave("Loro", 1.5, LocalDate.of(2023, 1, 20), LocalDate.of(2023, 6, 1),
                Dieta.OMNIVORO, 30);

        System.out.println("=== Agregar animales ===");
        Animal[] animales = { leon, cebra, elefante, jirafa };
        for (Animal a : animales) {
            try {
                zoo.agregarAnimal("Sabana", a);
                System.out.println(a.getNombre() + " agregado a Sabana");
            } catch (HabitatLlenoException e) {
                System.out.println("Hábitat lleno: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        try {
            zoo.agregarAnimal("Aviario", condor);
            zoo.agregarAnimal("Aviario", loro);
            System.out.println("Aves agregadas al Aviario");
            zoo.agregarAnimal("Acuario", loro);
        } catch (HabitatLlenoException e) {
            System.out.println("Hábitat lleno: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Costo diario de alimentación ===");
        for (Habitat h : zoo.getHabitats()) {
            for (Animal a : h.getAnimales()) {
                System.out.println(a.getNombre() + ": " + a.calcularCostoDiario());
            }
            System.out.println("Total " + h.getNombre() + ": " + h.calcularCostoDiario());
        }

        System.out.println();
        System.out.println("=== Interfaz Volador ===");
        System.out.println("Altura del cóndor: " + condor.getAltura());
        condor.volar();
        System.out.println("Altura del cóndor después de volar: " + condor.getAltura());

        System.out.println();
        System.out.println("=== Animales por dieta ===");
        Dieta[] dietas = Dieta.values();
        for (Dieta d : dietas) {
            System.out.println(d + ": " + zoo.contarAnimalesPorDieta(d));
        }

        System.out.println();
        System.out.println("=== Eliminar animales mayores de 20 años ===");
        int eliminados = zoo.eliminarAnimalesMayores(20, hoy);
        System.out.println("Animales eliminados: " + eliminados);
        System.out.println("Animales en Sabana: " + zoo.getHabitats().get(0).getAnimales().size());
        System.out.println("Herbívoros restantes: " + zoo.contarAnimalesPorDieta(Dieta.HERBIVORO));

        System.out.println();
        System.out.println("=== Guardar archivos ===");
        try {
            zoo.guardarAnimalesBinario("animales.dat");
            zoo.guardarAnimalesTexto("animales.txt");
            System.out.println("Archivos guardados");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
}
