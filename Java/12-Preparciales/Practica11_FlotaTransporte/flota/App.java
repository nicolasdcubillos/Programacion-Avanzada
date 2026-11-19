package flota;

import java.io.IOException;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("TransAndes");

        Bus bus = new Bus("BUS-101", 45000, 40);
        Camion camion1 = new Camion("CAM-201", 120000, 15);
        Camion camion2 = new Camion("CAM-202", 80000, 25);
        camion2.setEstado(Estado.MANTENIMIENTO);
        empresa.getVehiculos().add(bus);
        empresa.getVehiculos().add(camion1);
        empresa.getVehiculos().add(camion2);

        empresa.getConductores().add(new Conductor("Ana Gómez", "111", LocalDate.of(1985, 3, 12), LocalDate.of(2027, 6, 30)));
        empresa.getConductores().add(new Conductor("Luis Pérez", "222", LocalDate.of(1978, 9, 5), LocalDate.of(2024, 1, 15)));
        empresa.getConductores().add(new Conductor("Marta Ruiz", "333", LocalDate.of(1990, 11, 23), LocalDate.of(2025, 12, 31)));

        System.out.println("--- Seguros ---");
        for (Vehiculo v : empresa.getVehiculos()) {
            System.out.printf("%s: %.0f%n", v.getPlaca(), v.calcularSeguro());
        }

        System.out.println("--- Costo de viaje ---");
        try {
            System.out.printf("BUS-101 (100 km): %.0f%n", empresa.costoViaje("BUS-101", 100));
            System.out.printf("CAM-201 (100 km): %.0f%n", empresa.costoViaje("CAM-201", 100));
            System.out.printf("CAM-202 (100 km): %.0f%n", empresa.costoViaje("CAM-202", 100));
            System.out.printf("XXX-000 (100 km): %.0f%n", empresa.costoViaje("XXX-000", 100));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("--- Asignación de conductores ---");
        try {
            empresa.asignarConductor("BUS-101", "111");
            System.out.println("BUS-101 asignado a Ana Gómez");
            empresa.asignarConductor("BUS-101", "333");
        } catch (VehiculoNoDisponibleException e) {
            System.out.println("Excepción: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            empresa.asignarConductor("CAM-201", "999");
        } catch (VehiculoNoDisponibleException e) {
            System.out.println("Excepción: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            empresa.asignarConductor("CAM-202", "333");
        } catch (VehiculoNoDisponibleException e) {
            System.out.println("Excepción: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("--- Vehículos por estado ---");
        for (Estado estado : Estado.values()) {
            System.out.println(estado + ": " + empresa.contarPorEstado(estado));
        }

        System.out.println("--- Licencias vencidas ---");
        int eliminados = empresa.eliminarLicenciasVencidas(LocalDate.of(2025, 1, 1));
        System.out.println("Conductores eliminados: " + eliminados);
        System.out.println("Conductores restantes: " + empresa.getConductores().size());

        System.out.println("--- Archivos ---");
        try {
            empresa.guardarBinario("flota.dat");
            empresa.guardarTexto("flota.txt");
            System.out.println("Archivos guardados");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
