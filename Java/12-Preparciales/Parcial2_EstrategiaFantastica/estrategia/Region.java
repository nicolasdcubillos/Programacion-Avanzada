package estrategia;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Region {
    private String capital;
    private int recursos;
    private ArrayList<Personaje> ejercito;

    public Region(String capital, int recursos) {
        this.capital = capital;
        this.recursos = recursos;
        this.ejercito = new ArrayList<>();
    }

    // Soldado cuesta 5 recursos y Dragón 10; si no alcanzan, lanza excepción
    public void añadirPersonaje(String tipoPersonaje) throws RecursosInsuficientesException {
        if (tipoPersonaje.equalsIgnoreCase("soldado")) {
            if (recursos < 5) {
                throw new RecursosInsuficientesException("Recursos insuficientes para crear un soldado");
            }
            ejercito.add(new Soldado(10, 100, 15, 20));
            recursos -= 5;
        } else if (tipoPersonaje.equalsIgnoreCase("dragon")) {
            if (recursos < 10) {
                throw new RecursosInsuficientesException("Recursos insuficientes para crear un dragón");
            }
            ejercito.add(new Dragon(30, 300, 60));
            recursos -= 10;
        } else {
            throw new IllegalArgumentException("Tipo de personaje desconocido: " + tipoPersonaje);
        }
    }

    public int cantidadDragonesPoderosos() {
        int cantidad = 0;
        for (Personaje p : ejercito) {
            if (p instanceof Dragon && ((Dragon) p).getDañoFuego() > 50) {
                cantidad++;
            }
        }
        return cantidad;
    }

    // Serializa la lista completa del ejército (Personaje y Arma son Serializable)
    public void guardarPersonajesBinario(String ruta) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {
            out.writeObject(ejercito);
        }
    }

    public void guardarPersonajesTexto(String ruta) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Personaje p : ejercito) {
                String tipo;
                int adicional;
                if (p instanceof Dragon) {
                    tipo = "Dragón";
                    adicional = ((Dragon) p).getDañoFuego();
                } else {
                    tipo = "Soldado";
                    adicional = ((Soldado) p).getArma().getAtaque();
                }
                bw.write("Tipo de personaje: " + tipo);
                bw.newLine();
                bw.write("Ataque base: " + p.getAtaqueBase());
                bw.newLine();
                bw.write("Vida: " + p.getVida());
                bw.newLine();
                bw.write("Ataque adicional: " + adicional);
                bw.newLine();
                bw.newLine();
            }
        }
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getRecursos() {
        return recursos;
    }

    public void setRecursos(int recursos) {
        this.recursos = recursos;
    }

    public ArrayList<Personaje> getEjercito() {
        return ejercito;
    }
}
