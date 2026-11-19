package cine;

import java.io.IOException;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Cine cine = new Cine("Cine Central", "Medellín");

        Pelicula dune = new Pelicula("Dune", 155, Formato.TRES_D);
        Pelicula intensamente = new Pelicula("Intensamente", 96, Formato.DOS_D);
        Pelicula avatar = new Pelicula("Avatar", 190, Formato.TRES_D);

        FuncionNormal f1 = new FuncionNormal(intensamente, "14:00", 15000, 5);
        FuncionNormal f2 = new FuncionNormal(dune, "17:00", 15000, 5);
        FuncionVip f3 = new FuncionVip(avatar, "20:00", 15000, 3, 10000);
        FuncionVip f4 = new FuncionVip(intensamente, "22:00", 15000, 3, 10000);
        cine.getFunciones().add(f1);
        cine.getFunciones().add(f2);
        cine.getFunciones().add(f3);
        cine.getFunciones().add(f4);

        Espectador nino = new Espectador("Sofía", LocalDate.of(2018, 5, 10));
        Espectador adulto = new Espectador("Carlos", LocalDate.of(1995, 3, 20));
        Espectador mayor = new Espectador("Marta", LocalDate.of(1955, 8, 1));

        System.out.println("=== Precios ===");
        System.out.println("Normal 2D adulto: " + f1.calcularPrecio(adulto.getFechaNacimiento())); // 15000
        System.out.println("Normal 3D niño: " + f2.calcularPrecio(nino.getFechaNacimiento())); // 14700
        System.out.println("VIP 3D mayor: " + f3.calcularPrecio(mayor.getFechaNacimiento())); // 24800
        System.out.println("VIP 2D adulto: " + f4.calcularPrecio(adulto.getFechaNacimiento())); // 25000

        System.out.println("=== Venta de boletos ===");
        try {
            System.out.println("Venta: " + f1.venderBoleto(1, adulto));
            System.out.println("Venta: " + f1.venderBoleto(2, nino));
            System.out.println("Venta: " + f3.venderBoleto(3, mayor));
            System.out.println("Venta: " + f3.venderBoleto(1, adulto));
            System.out.println("Venta: " + f1.venderBoleto(1, mayor)); // silla ocupada
        } catch (SillaOcupadaException e) {
            System.out.println("Silla ocupada: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            System.out.println("Venta: " + f2.venderBoleto(9, adulto)); // silla inexistente
        } catch (SillaOcupadaException e) {
            System.out.println("Silla ocupada: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Boletos F1: " + f1.getBoletos().size());
        System.out.println("Boletos F3: " + f3.getBoletos().size());

        System.out.println("=== Funciones por formato ===");
        System.out.println("2D: " + cine.contarFuncionesPorFormato(Formato.DOS_D)); // 2
        System.out.println("3D: " + cine.contarFuncionesPorFormato(Formato.TRES_D)); // 2

        System.out.println("=== Archivos ===");
        try {
            cine.guardarFuncionesBinario("funciones.dat");
            cine.guardarFuncionesTexto("funciones.txt");
            System.out.println("Archivos guardados");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("=== Eliminar funciones sin boletos ===");
        System.out.println("Eliminadas: " + cine.eliminarFuncionesSinBoletos()); // 2 (f2 y f4)
        System.out.println("Funciones restantes: " + cine.getFunciones().size()); // 2
    }
}
