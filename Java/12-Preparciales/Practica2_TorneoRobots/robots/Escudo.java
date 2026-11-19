package robots;

import java.io.Serializable;

public class Escudo implements Serializable {
    private static final long serialVersionUID = 1L;

    private int resistencia;
    private int durabilidad;

    public Escudo(int resistencia, int durabilidad) {
        this.resistencia = resistencia;
        this.durabilidad = durabilidad;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getDurabilidad() {
        return durabilidad;
    }

    public void setDurabilidad(int durabilidad) {
        this.durabilidad = durabilidad;
    }
}
