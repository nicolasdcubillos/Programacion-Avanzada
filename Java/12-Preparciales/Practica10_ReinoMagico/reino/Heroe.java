package reino;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Heroe implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int danoBase;
    private int vida;
    private ArrayList<Heroe> enemigos;

    public Heroe(String nombre, int danoBase, int vida) {
        this.nombre = nombre;
        this.danoBase = danoBase;
        this.vida = vida;
        this.enemigos = new ArrayList<>();
    }

    public abstract void atacar(Heroe objetivo);

    // Ataca a todos los enemigos y elimina los que quedan con vida <= 0
    public void atacarEnemigos() {
        for (Heroe enemigo : enemigos) {
            atacar(enemigo);
        }
        for (int i = enemigos.size() - 1; i >= 0; i--) {
            if (enemigos.get(i).getVida() <= 0) {
                enemigos.remove(i);
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDanoBase() {
        return danoBase;
    }

    public void setDanoBase(int danoBase) {
        this.danoBase = danoBase;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public ArrayList<Heroe> getEnemigos() {
        return enemigos;
    }
}
