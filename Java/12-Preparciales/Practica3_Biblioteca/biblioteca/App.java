package biblioteca;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");
        biblioteca.getLibros().add(new LibroFisico("Cien años de soledad", Genero.NOVELA, 560));
        biblioteca.getLibros().add(new LibroFisico("El principito", Genero.INFANTIL, 96));
        biblioteca.getLibros().add(new LibroDigital("Breve historia del tiempo", Genero.CIENCIA, 12));
        biblioteca.getLibros().add(new LibroDigital("Sapiens", Genero.HISTORIA, 25));
        biblioteca.getLibros().add(new LibroFisico("Cosmos", Genero.CIENCIA, 400));

        biblioteca.getUsuarios().add(new Usuario("Ana", "100"));
        biblioteca.getUsuarios().add(new Usuario("Luis", "200"));
        biblioteca.getUsuarios().add(new Usuario("Marta", "300"));

        LocalDate hoy = LocalDate.of(2026, 3, 1);
        try {
            biblioteca.prestarLibro("Cien años de soledad", "100", hoy);
            biblioteca.prestarLibro("Sapiens", "100", hoy);
            biblioteca.prestarLibro("Cosmos", "200", hoy);
            System.out.println("Préstamos realizados");
            biblioteca.prestarLibro("Sapiens", "200", hoy);
        } catch (LibroNoDisponibleException e) {
            System.out.println("Excepción: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            biblioteca.prestarLibro("Libro inexistente", "200", hoy);
        } catch (LibroNoDisponibleException e) {
            System.out.println("Excepción: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Ana devuelve 5 días tarde: 5*1000 + 2000 (560 páginas) = 7000 y 5*300 = 1500
        LocalDate entrega = LocalDate.of(2026, 3, 13);
        Usuario ana = biblioteca.getUsuarios().get(0);
        Usuario luis = biblioteca.getUsuarios().get(1);
        System.out.println("Multa de Ana: " + ana.calcularMultaTotal(entrega));
        System.out.println("Multa de Luis: " + luis.calcularMultaTotal(entrega));
        System.out.println("Multa de Ana a tiempo: " + ana.calcularMultaTotal(LocalDate.of(2026, 3, 5)));

        ArrayList<Libro> ciencia = biblioteca.buscarPorGenero(Genero.CIENCIA);
        System.out.println("Libros de CIENCIA disponibles: " + ciencia.size());
        for (Libro libro : ciencia) {
            System.out.println(" - " + libro.getTitulo());
        }

        System.out.println("Usuarios eliminados: " + biblioteca.eliminarUsuariosSinPrestamos());
        System.out.println("Usuarios restantes: " + biblioteca.getUsuarios().size());

        try {
            biblioteca.guardarLibrosBinario("libros.dat");
            biblioteca.guardarLibrosTexto("libros.txt");
            System.out.println("Archivos guardados");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
