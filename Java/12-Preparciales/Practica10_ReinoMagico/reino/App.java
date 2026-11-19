package reino;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        Reino reino = new Reino("Eldoria", 50, 25);

        // reclutarHeroe: 25 mana -> mago (15) -> guerrero (oro 30) -> mago (5) -> mago falla
        try {
            reino.reclutarHeroe("mago");
            reino.reclutarHeroe("guerrero");
            reino.reclutarHeroe("mago");
            System.out.println("Héroes reclutados: " + reino.getHeroes().size());
            reino.reclutarHeroe("mago"); // mana 5 < 10 -> falla
        } catch (ManaInsuficienteException e) {
            System.out.println("Excepción propia: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            reino.reclutarHeroe("arquero");
        } catch (ManaInsuficienteException e) {
            System.out.println("Excepción propia: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Mana: " + reino.getMana() + ", oro: " + reino.getOro());

        Mago mago1 = (Mago) reino.getHeroes().get(0);
        Guerrero guerrero = (Guerrero) reino.getHeroes().get(1);
        Mago mago2 = (Mago) reino.getHeroes().get(2);
        mago2.setElemento(Elemento.AGUA);
        reino.getHeroes().add(new Mago("Gaia", 8, 70, Elemento.TIERRA, "Terremoto", 18));
        reino.getHeroes().add(new Mago("Nereo", 9, 60, Elemento.AGUA, "Marea", 20));

        // atacar polimórfico
        Heroe objetivo = reino.getHeroes().get(3);
        mago1.atacar(objetivo); // 10 + 25 = 35 -> vida 35
        guerrero.atacar(objetivo); // 12 + 15 = 27 -> vida 8
        System.out.println("Vida de " + objetivo.getNombre() + ": " + objetivo.getVida());
        System.out.println("Durabilidad del arma: " + guerrero.getDurabilidadArma());

        // curar
        mago2.curar(objetivo);
        System.out.println("Vida de " + objetivo.getNombre() + " tras curar: " + objetivo.getVida());

        // atacarEnemigos
        mago1.getEnemigos().add(reino.getHeroes().get(3)); // vida 28
        mago1.getEnemigos().add(reino.getHeroes().get(4)); // vida 60
        mago1.atacarEnemigos(); // -35 -> 28-35=-7 (eliminado), 60-35=25
        System.out.println("Enemigos restantes: " + mago1.getEnemigos().size());
        mago1.atacarEnemigos(); // 25-35=-10 -> eliminado
        System.out.println("Enemigos restantes: " + mago1.getEnemigos().size());

        System.out.println("Magos de FUEGO: " + reino.contarMagosPorElemento(Elemento.FUEGO));
        System.out.println("Magos de AGUA: " + reino.contarMagosPorElemento(Elemento.AGUA));
        System.out.println("Magos de TIERRA: " + reino.contarMagosPorElemento(Elemento.TIERRA));

        try {
            reino.guardarHeroesBinario("heroes.dat");
            reino.guardarHeroesTexto("heroes.txt");
            System.out.println("Archivos guardados");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
