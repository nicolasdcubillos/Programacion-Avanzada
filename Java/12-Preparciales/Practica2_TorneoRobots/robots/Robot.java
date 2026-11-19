package robots;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Robot implements Serializable {
    private static final long serialVersionUID = 1L;

    private int potenciaBase;
    private int bateria;
    private ArrayList<Robot> objetivos;

    public Robot(int potenciaBase, int bateria) {
        this.potenciaBase = potenciaBase;
        this.bateria = bateria;
        this.objetivos = new ArrayList<>();
    }

    public abstract void atacar(Robot objetivo);

    // Ataca a todos los objetivos y elimina los que quedan con batería <= 0
    public void atacarObjetivos() {
        for (Robot objetivo : objetivos) {
            atacar(objetivo);
        }
        for (int i = objetivos.size() - 1; i >= 0; i--) {
            if (objetivos.get(i).getBateria() <= 0) {
                objetivos.remove(i);
            }
        }
    }

    public int getPotenciaBase() {
        return potenciaBase;
    }

    public void setPotenciaBase(int potenciaBase) {
        this.potenciaBase = potenciaBase;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    public ArrayList<Robot> getObjetivos() {
        return objetivos;
    }
}
