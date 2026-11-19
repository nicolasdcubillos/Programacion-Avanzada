package robots;

public class RobotVolador extends Robot {
    private static final long serialVersionUID = 1L;

    private int danoLaser;

    public RobotVolador(int potenciaBase, int bateria, int danoLaser) {
        super(potenciaBase, bateria);
        this.danoLaser = danoLaser;
    }

    @Override
    public void atacar(Robot objetivo) {
        objetivo.setBateria(objetivo.getBateria() - (getPotenciaBase() + danoLaser));
    }

    public int getDanoLaser() {
        return danoLaser;
    }

    public void setDanoLaser(int danoLaser) {
        this.danoLaser = danoLaser;
    }
}
