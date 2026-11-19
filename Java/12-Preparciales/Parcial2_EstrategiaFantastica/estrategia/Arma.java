package estrategia;

import java.io.Serializable;

public class Arma implements Serializable {
    private static final long serialVersionUID = 1L;

    private int ataque;
    private int durabilidad;

    public Arma(int ataque, int durabilidad) {
        this.ataque = ataque;
        this.durabilidad = durabilidad;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDurabilidad() {
        return durabilidad;
    }

    public void setDurabilidad(int durabilidad) {
        this.durabilidad = durabilidad;
    }
}
