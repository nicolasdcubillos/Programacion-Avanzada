package estrategia;

public class Soldado extends Personaje {
    private static final long serialVersionUID = 1L;

    private Arma arma;

    // Recibe ataque y durabilidad para crear el arma
    public Soldado(int ataqueBase, int vida, int ataqueArma, int durabilidad) {
        super(ataqueBase, vida);
        this.arma = new Arma(ataqueArma, durabilidad);
    }

    @Override
    public void atacar(Personaje objetivo) {
        objetivo.setVida(objetivo.getVida() - (getAtaqueBase() + arma.getAtaque()));
        arma.setDurabilidad(arma.getDurabilidad() - 1);
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }
}
