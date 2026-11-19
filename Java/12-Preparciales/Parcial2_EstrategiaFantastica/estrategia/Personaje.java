package estrategia;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Personaje implements Serializable {
    private static final long serialVersionUID = 1L;

    private int ataqueBase;
    private int vida;
    private ArrayList<Personaje> objetivos;

    // La lista de objetivos se crea vacía
    public Personaje(int ataqueBase, int vida) {
        this.ataqueBase = ataqueBase;
        this.vida = vida;
        this.objetivos = new ArrayList<>();
    }

    public abstract void atacar(Personaje objetivo);

    // Ataca a todos los objetivos y elimina de la lista los que quedan con vida negativa
    public void atacarObjetivos() {
        for (Personaje objetivo : objetivos) {
            atacar(objetivo);
        }
        for (int i = objetivos.size() - 1; i >= 0; i--) {
            if (objetivos.get(i).getVida() < 0) {
                objetivos.remove(i);
            }
        }
    }

    public int getAtaqueBase() {
        return ataqueBase;
    }

    public void setAtaqueBase(int ataqueBase) {
        this.ataqueBase = ataqueBase;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public ArrayList<Personaje> getObjetivos() {
        return objetivos;
    }
}
