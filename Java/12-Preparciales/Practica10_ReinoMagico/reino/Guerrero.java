package reino;

public class Guerrero extends Heroe {
    private static final long serialVersionUID = 1L;

    private int fuerzaArma;
    private int durabilidadArma;

    public Guerrero(String nombre, int danoBase, int vida, int fuerzaArma, int durabilidadArma) {
        super(nombre, danoBase, vida);
        this.fuerzaArma = fuerzaArma;
        this.durabilidadArma = durabilidadArma;
    }

    @Override
    public void atacar(Heroe objetivo) {
        objetivo.setVida(objetivo.getVida() - (getDanoBase() + fuerzaArma));
        durabilidadArma -= 2;
    }

    public int getFuerzaArma() {
        return fuerzaArma;
    }

    public void setFuerzaArma(int fuerzaArma) {
        this.fuerzaArma = fuerzaArma;
    }

    public int getDurabilidadArma() {
        return durabilidadArma;
    }

    public void setDurabilidadArma(int durabilidadArma) {
        this.durabilidadArma = durabilidadArma;
    }
}
