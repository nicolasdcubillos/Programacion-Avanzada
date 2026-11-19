package cine;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Cine {
    private String nombre;
    private String ciudad;
    private ArrayList<Funcion> funciones;

    public Cine(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.funciones = new ArrayList<>();
    }

    // Cuenta las funciones cuya película tiene el formato indicado
    public int contarFuncionesPorFormato(Formato formato) {
        int cantidad = 0;
        for (Funcion f : funciones) {
            if (f.getPelicula().getFormato() == formato) {
                cantidad++;
            }
        }
        return cantidad;
    }

    // Elimina las funciones sin boletos y retorna cuántas eliminó
    public int eliminarFuncionesSinBoletos() {
        int eliminadas = 0;
        for (int i = funciones.size() - 1; i >= 0; i--) {
            if (funciones.get(i).getBoletos().size() == 0) {
                funciones.remove(i);
                eliminadas++;
            }
        }
        return eliminadas;
    }

    public void guardarFuncionesBinario(String ruta) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {
            out.writeObject(funciones);
        }
    }

    public void guardarFuncionesTexto(String ruta) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Funcion f : funciones) {
                String tipo;
                if (f instanceof FuncionVip) {
                    tipo = "VIP";
                } else {
                    tipo = "Normal";
                }
                int recaudado = 0;
                for (Boleto b : f.getBoletos()) {
                    recaudado += b.getPrecio();
                }
                bw.write("Tipo de función: " + tipo);
                bw.newLine();
                bw.write("Película: " + f.getPelicula().getTitulo());
                bw.newLine();
                bw.write("Formato: " + f.getPelicula().getFormato());
                bw.newLine();
                bw.write("Horario: " + f.getHorario());
                bw.newLine();
                bw.write("Boletos vendidos: " + f.getBoletos().size());
                bw.newLine();
                bw.write("Recaudado: " + recaudado);
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public ArrayList<Funcion> getFunciones() {
        return funciones;
    }
}
