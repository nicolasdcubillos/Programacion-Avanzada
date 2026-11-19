package reino;

public class Mago extends Heroe implements Curable {
    private static final long serialVersionUID = 1L;

    private Elemento elemento;
    private Hechizo hechizo;

    public Mago(String nombre, int danoBase, int vida, Elemento elemento, String nombreHechizo, int poderHechizo) {
        super(nombre, danoBase, vida);
        this.elemento = elemento;
        this.hechizo = new Hechizo(nombreHechizo, poderHechizo);
    }

    @Override
    public void atacar(Heroe objetivo) {
        objetivo.setVida(objetivo.getVida() - (getDanoBase() + hechizo.getPoder()));
    }

    @Override
    public void curar(Heroe objetivo) {
        objetivo.setVida(objetivo.getVida() + 20);
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public Hechizo getHechizo() {
        return hechizo;
    }

    public void setHechizo(Hechizo hechizo) {
        this.hechizo = hechizo;
    }
}
