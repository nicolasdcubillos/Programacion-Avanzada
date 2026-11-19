package veterinaria;

import java.io.IOException;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        LocalDate hoy = LocalDate.of(2026, 11, 19);
        Veterinaria vet = new Veterinaria("Patitas Felices");

        Dueno ana = new Dueno("Ana Gómez", "111", "3001112233");
        Dueno luis = new Dueno("Luis Pérez", "222", "3004445566");

        Perro rex = new Perro("Rex", LocalDate.of(2020, 3, 10), LocalDate.of(2026, 2, 1), EstadoSalud.SANO, ana, 30);
        Gato misu = new Gato("Misu", LocalDate.of(2012, 6, 1), LocalDate.of(2024, 5, 20), EstadoSalud.EN_TRATAMIENTO, luis, false);
        Perro toby = new Perro("Toby", LocalDate.of(2023, 1, 15), LocalDate.of(2026, 1, 10), EstadoSalud.CRITICO, luis, 10);
        Gato nina = new Gato("Nina", LocalDate.of(2015, 9, 9), LocalDate.of(2025, 3, 1), EstadoSalud.SANO, ana, true);

        System.out.println("=== Registro de mascotas ===");
        try {
            vet.registrarMascota(rex);
            vet.registrarMascota(misu);
            vet.registrarMascota(toby);
            vet.registrarMascota(nina);
            System.out.println("Mascotas registradas: " + vet.getMascotas().size());
            System.out.println("Dueños registrados: " + vet.getDuenos().size());
            vet.registrarMascota(new Perro("rex", LocalDate.of(2021, 1, 1), LocalDate.of(2026, 1, 1), EstadoSalud.SANO, ana, 12));
        } catch (MascotaYaRegistradaException e) {
            System.out.println("Excepción propia: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Costos de consulta (polimorfismo) ===");
        for (Mascota m : vet.getMascotas()) {
            System.out.println(m.getNombre() + ": $" + m.calcularCostoConsulta());
        }

        System.out.println();
        System.out.println("=== Costo total por dueño ===");
        try {
            System.out.println("Ana (111): $" + vet.calcularCostoDueno("111"));
            System.out.println("Luis (222): $" + vet.calcularCostoDueno("222"));
            System.out.println("Cédula 999: $" + vet.calcularCostoDueno("999"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Vacunas ===");
        System.out.println("Vacunas vencidas al " + hoy + ": " + vet.contarVacunasVencidas(hoy));
        try {
            misu.aplicarVacuna(hoy);
            System.out.println("Misu vacunada el " + hoy + ", vigente: " + misu.estaVacunada(hoy));
            System.out.println("Vacunas vencidas ahora: " + vet.contarVacunasVencidas(hoy));
            rex.aplicarVacuna(LocalDate.of(2025, 1, 1));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Eliminar mascotas de más de 10 años ===");
        int eliminadas = vet.eliminarMascotasMayores(10, hoy);
        System.out.println("Mascotas eliminadas: " + eliminadas);
        for (Mascota m : vet.getMascotas()) {
            System.out.println("Queda: " + m.getNombre() + " (" + m.calcularEdad(hoy) + " años)");
        }

        System.out.println();
        System.out.println("=== Archivos ===");
        try {
            vet.guardarMascotasBinario("mascotas.dat");
            vet.guardarMascotasTexto("mascotas.txt");
            System.out.println("Archivos guardados");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
