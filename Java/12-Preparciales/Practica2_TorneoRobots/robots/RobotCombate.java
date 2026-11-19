package robots;

public class RobotCombate extends Robot {
    private static final long serialVersionUID = 1L;

    private Escudo escudo;

    public RobotCombate(int potenciaBase, int bateria, int resistenciaEscudo, int durabilidad) {
        super(potenciaBase, bateria);
        this.escudo = new Escudo(resistenciaEscudo, durabilidad);
    }

    @Override
    public void atacar(Robot objetivo) {
        objetivo.setBateria(objetivo.getBateria() - (getPotenciaBase() + escudo.getResistencia()));
        escudo.setDurabilidad(escudo.getDurabilidad() - 2);
    }

    public Escudo getEscudo() {
        return escudo;
    }

    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }
}
