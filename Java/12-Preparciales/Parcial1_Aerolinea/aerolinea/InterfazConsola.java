package aerolinea;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class InterfazConsola {
    private Aerolinea aerolinea;

    public InterfazConsola(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    // Guarda la aerolínea en un archivo serializado
    public void guardarAerolinea() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("aerolinea.dat"))) {
            out.writeObject(aerolinea);
            System.out.println("Aerolínea guardada en aerolinea.dat");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Aerolinea avianca = new Aerolinea("Avianca");

        Nacional n = new Nacional("Bogota", "Pereira", LocalDate.of(2025, 9, 25),
                LocalDate.of(2025, 9, 25), 2850, 150000f, "Mediano");
        Internacional i = new Internacional("Bogota", "Orlando", LocalDate.of(2025, 12, 25),
                LocalDate.of(2025, 12, 26), 2055, 3500000f, 250000);
        i.agregarRequisito(new RequisitosMigratorio("visa"));
        avianca.agregarVuelo(n);
        avianca.agregarVuelo(i);

        try {
            avianca.agregarPasajero(2850, "Ana", 1, LocalDate.of(1995, 5, 10), 12);
            avianca.agregarPasajero(2850, "Luis", 2, LocalDate.of(2015, 1, 1), 13);
            avianca.agregarPasajero(2850, "Ana", 1, LocalDate.of(1995, 5, 10), 12); // repetido
        } catch (PasajeroExistenteException e) {
            System.out.println("Excepción: " + e.getMessage());
        }

        n.eliminarPasajerosMenoresDeEdad();
        System.out.println("Pasajeros tras eliminar menores: " + n.getPasajeros().size());
        System.out.println("Valor nacional: " + n.calcularValor());
        System.out.println("Valor internacional: " + i.calcularValor());
        System.out.println("Con visa: " + avianca.vuelosConRestricciones("visa"));

        try {
            avianca.generarReporte("Bogota");
            System.out.println("Reporte generado en vuelosOrigen.txt");
        } catch (IOException e) {
            System.out.println("Error en reporte: " + e.getMessage());
        }

        new InterfazConsola(avianca).guardarAerolinea();
    }
}
