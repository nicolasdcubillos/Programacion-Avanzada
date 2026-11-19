package reino;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Reino {
    private String nombre;
    private int oro;
    private int mana;
    private ArrayList<Heroe> heroes;

    public Reino(String nombre, int oro, int mana) {
        this.nombre = nombre;
        this.oro = oro;
        this.mana = mana;
        this.heroes = new ArrayList<>();
    }

    public void reclutarHeroe(String tipoHeroe) throws ManaInsuficienteException, Exception {
        if (tipoHeroe.equalsIgnoreCase("mago")) {
            if (mana < 10) {
                throw new ManaInsuficienteException("Mana insuficiente para reclutar un mago");
            }
            heroes.add(new Mago("Mago" + (heroes.size() + 1), 10, 80, Elemento.FUEGO, "Bola de fuego", 25));
            mana -= 10;
        } else if (tipoHeroe.equalsIgnoreCase("guerrero")) {
            if (oro < 20) {
                throw new Exception("Oro insuficiente para reclutar un guerrero");
            }
            heroes.add(new Guerrero("Guerrero" + (heroes.size() + 1), 12, 120, 15, 10));
            oro -= 20;
        } else {
            throw new Exception("Tipo de héroe desconocido: " + tipoHeroe);
        }
    }

    public int contarMagosPorElemento(Elemento elemento) {
        int cantidad = 0;
        for (Heroe h : heroes) {
            if (h instanceof Mago && ((Mago) h).getElemento() == elemento) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public void guardarHeroesBinario(String ruta) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {
            out.writeObject(heroes);
        }
    }

    public void guardarHeroesTexto(String ruta) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Heroe h : heroes) {
                String tipo;
                int adicional;
                if (h instanceof Mago) {
                    tipo = "Mago";
                    adicional = ((Mago) h).getHechizo().getPoder();
                } else {
                    tipo = "Guerrero";
                    adicional = ((Guerrero) h).getFuerzaArma();
                }
                bw.write("Tipo de héroe: " + tipo);
                bw.newLine();
                bw.write("Nombre: " + h.getNombre());
                bw.newLine();
                bw.write("Daño base: " + h.getDanoBase());
                bw.newLine();
                bw.write("Vida: " + h.getVida());
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

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public ArrayList<Heroe> getHeroes() {
        return heroes;
    }
}
