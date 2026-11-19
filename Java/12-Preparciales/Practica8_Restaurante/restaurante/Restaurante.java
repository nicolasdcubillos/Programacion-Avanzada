package restaurante;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Restaurante {
    private String nombre;
    private ArrayList<Plato> menu;
    private ArrayList<Pedido> pedidos;

    public Restaurante(String nombre) {
        this.nombre = nombre;
        this.menu = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public Plato buscarPlato(String nombrePlato) throws Exception {
        for (Plato p : menu) {
            if (p.getNombre().equalsIgnoreCase(nombrePlato)) {
                return p;
            }
        }
        throw new Exception("No existe el plato: " + nombrePlato);
    }

    public int contarPlatosPorCategoria(Categoria categoria) {
        int cantidad = 0;
        for (Plato p : menu) {
            if (p.getCategoria() == categoria) {
                cantidad++;
            }
        }
        return cantidad;
    }

    // Elimina del menú los platos sin ingredientes y retorna cuántos eliminó
    public int eliminarPlatosAgotados() {
        int eliminados = 0;
        for (int i = menu.size() - 1; i >= 0; i--) {
            if (menu.get(i).getIngredientes() <= 0) {
                menu.remove(i);
                eliminados++;
            }
        }
        return eliminados;
    }

    public void guardarMenuBinario(String ruta) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {
            out.writeObject(menu);
        }
    }

    public void guardarMenuTexto(String ruta) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Plato p : menu) {
                String tipo;
                double adicional;
                if (p instanceof PlatoFuerte) {
                    tipo = "Fuerte";
                    adicional = ((PlatoFuerte) p).getAdicion();
                } else {
                    tipo = "Postre";
                    adicional = ((Postre) p).getPorcentajeDescuento();
                }
                bw.write("Tipo de plato: " + tipo);
                bw.newLine();
                bw.write("Nombre: " + p.getNombre());
                bw.newLine();
                bw.write("Categoría: " + p.getCategoria());
                bw.newLine();
                bw.write("Precio base: " + p.getPrecioBase());
                bw.newLine();
                bw.write("Valor adicional: " + adicional);
                bw.newLine();
                bw.newLine();
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Plato> getMenu() {
        return menu;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
