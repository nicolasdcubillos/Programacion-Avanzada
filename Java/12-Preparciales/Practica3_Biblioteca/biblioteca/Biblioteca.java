package biblioteca;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void prestarLibro(String titulo, String documento, LocalDate fechaPrestamo)
            throws LibroNoDisponibleException, Exception {
        Libro libro = null;
        for (Libro l : libros) {
            if (l.getTitulo().equals(titulo)) {
                libro = l;
            }
        }
        if (libro == null) {
            throw new Exception("Libro no encontrado: " + titulo);
        }

        Usuario usuario = null;
        for (Usuario u : usuarios) {
            if (u.getDocumento().equals(documento)) {
                usuario = u;
            }
        }
        if (usuario == null) {
            throw new Exception("Usuario no encontrado: " + documento);
        }

        if (!libro.isDisponible()) {
            throw new LibroNoDisponibleException("El libro no está disponible: " + titulo);
        }
        if (usuario.getPrestamos().size() >= 3) {
            throw new Exception("El usuario ya tiene 3 préstamos activos");
        }

        libro.setDisponible(false);
        libro.setFechaPrestamo(fechaPrestamo);
        libro.setFechaDevolucion(fechaPrestamo.plusDays(7));
        usuario.getPrestamos().add(libro);
    }

    public ArrayList<Libro> buscarPorGenero(Genero genero) {
        ArrayList<Libro> resultado = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getGenero() == genero && libro.isDisponible()) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    public int eliminarUsuariosSinPrestamos() {
        int eliminados = 0;
        for (int i = usuarios.size() - 1; i >= 0; i--) {
            if (usuarios.get(i).getPrestamos().size() == 0) {
                usuarios.remove(i);
                eliminados++;
            }
        }
        return eliminados;
    }

    public void guardarLibrosBinario(String ruta) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {
            out.writeObject(libros);
        }
    }

    public void guardarLibrosTexto(String ruta) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Libro libro : libros) {
                String tipo;
                int adicional;
                if (libro instanceof LibroFisico) {
                    tipo = "Físico";
                    adicional = ((LibroFisico) libro).getNumeroPaginas();
                } else {
                    tipo = "Digital";
                    adicional = ((LibroDigital) libro).getTamanoMb();
                }
                bw.write("Tipo de libro: " + tipo);
                bw.newLine();
                bw.write("Título: " + libro.getTitulo());
                bw.newLine();
                bw.write("Género: " + libro.getGenero());
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

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
