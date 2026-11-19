package restaurante;

import java.io.IOException;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante("La Sazón");

        Plato bandeja = new PlatoFuerte("Bandeja paisa", 30000, Categoria.CARNE, 2, 5000);
        Plato lasana = new PlatoFuerte("Lasaña", 25000, Categoria.PASTA, 1, 0);
        Plato sopa = new PlatoFuerte("Crema de tomate", 12000, Categoria.ENTRADA, 3, 2000);
        Plato brownie = new Postre("Brownie", 10000, Categoria.DULCE, 2, 20);
        Plato helado = new Postre("Helado de vainilla", 8000, Categoria.HELADO, 0, 10);
        restaurante.getMenu().add(bandeja);
        restaurante.getMenu().add(lasana);
        restaurante.getMenu().add(sopa);
        restaurante.getMenu().add(brownie);
        restaurante.getMenu().add(helado);

        System.out.println("=== Precios finales ===");
        for (Plato p : restaurante.getMenu()) {
            System.out.println(p.getNombre() + ": " + p.calcularPrecioFinal());
        }
        // Esperado: 38500.0, 27500.0, 15400.0, 8000.0, 7200.0

        System.out.println("=== Preparar platos ===");
        try {
            lasana.preparar();
            System.out.println("Lasaña preparada. Ingredientes restantes: " + lasana.getIngredientes());
            lasana.preparar(); // ya no quedan ingredientes
            System.out.println("Esto no se imprime");
        } catch (IngredienteAgotadoException e) {
            System.out.println("Ingredientes: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("=== Pedido ===");
        Pedido pedido = new Pedido("Camila", LocalDate.of(2026, 11, 19));
        pedido.getPlatos().add(bandeja);
        pedido.getPlatos().add(sopa);
        pedido.getPlatos().add(brownie);
        System.out.println("Total con 3 platos: " + pedido.calcularTotal()); // 61900.0
        pedido.getPlatos().add(helado);
        System.out.println("Total con 4 platos: " + pedido.calcularTotal()); // 69100.0 - 10% = 62190.0
        restaurante.getPedidos().add(pedido);

        System.out.println("=== Búsqueda y conteo ===");
        try {
            System.out.println("Encontrado: " + restaurante.buscarPlato("brownie").getNombre());
            restaurante.buscarPlato("Pizza");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Platos de categoría CARNE: " + restaurante.contarPlatosPorCategoria(Categoria.CARNE));
        System.out.println("Platos de categoría DULCE: " + restaurante.contarPlatosPorCategoria(Categoria.DULCE));

        System.out.println("=== Eliminar agotados ===");
        int eliminados = restaurante.eliminarPlatosAgotados(); // helado (0) y lasaña (0)
        System.out.println("Platos eliminados: " + eliminados);
        for (Plato p : restaurante.getMenu()) {
            System.out.println("En menú: " + p.getNombre());
        }

        try {
            restaurante.guardarMenuBinario("menu.dat");
            restaurante.guardarMenuTexto("menu.txt");
            System.out.println("Archivos guardados");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
