package estrategia;

public class Dragon extends Personaje {
    private static final long serialVersionUID = 1L;

    private int dañoFuego;

    public Dragon(int ataqueBase, int vida, int dañoFuego) {
        super(ataqueBase, vida);
        this.dañoFuego = dañoFuego;
    }

    @Override
    public void atacar(Personaje objetivo) {
        objetivo.setVida(objetivo.getVida() - (getAtaqueBase() + dañoFuego));
    }

    public int getDañoFuego() {
        return dañoFuego;
    }

    public void setDañoFuego(int dañoFuego) {
        this.dañoFuego = dañoFuego;
    }
}
