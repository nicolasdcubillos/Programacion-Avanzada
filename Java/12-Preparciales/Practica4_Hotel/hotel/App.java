package hotel;

import java.io.IOException;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hotel Central");

        hotel.getHabitaciones().add(new HabitacionSencilla(101, TipoCama.INDIVIDUAL, 120000, true));
        hotel.getHabitaciones().add(new HabitacionSencilla(102, TipoCama.DOBLE, 150000, false));
        hotel.getHabitaciones().add(new Suite(301, TipoCama.KING, 300000, true, 2));
        hotel.getHabitaciones().add(new Suite(302, TipoCama.KING, 280000, false, 1));

        hotel.getHuespedes().add(new Huesped("Ana Torres", 1001, LocalDate.of(1990, 5, 12)));
        hotel.getHuespedes().add(new Huesped("Luis Pérez", 1002, LocalDate.of(2015, 3, 8)));
        hotel.getHuespedes().add(new Huesped("Marta Ríos", 1003, LocalDate.of(1985, 11, 30)));
        hotel.getHuespedes().add(new Huesped("Sofía Gil", 1004, LocalDate.of(2012, 7, 21)));

        try {
            int costo1 = hotel.reservarHabitacion(101, 1001, LocalDate.of(2027, 1, 10), LocalDate.of(2027, 1, 13));
            System.out.println("Costo habitación 101 (3 noches): " + costo1); // (120000 + 12000) * 3 = 396000
            int costo2 = hotel.reservarHabitacion(301, 1003, LocalDate.of(2027, 1, 10), LocalDate.of(2027, 1, 12));
            System.out.println("Costo suite 301 (2 noches): " + costo2); // (300000 + 30000) * 2 + 40000 = 700000
            hotel.reservarHabitacion(101, 1003, LocalDate.of(2027, 1, 12), LocalDate.of(2027, 1, 14)); // se cruza
            System.out.println("Esta línea no debería imprimirse");
        } catch (HabitacionOcupadaException e) {
            System.out.println("Habitación ocupada: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Sale el mismo día que empieza la otra reserva: no hay cruce
            int costo3 = hotel.reservarHabitacion(101, 1003, LocalDate.of(2027, 1, 13), LocalDate.of(2027, 1, 14));
            System.out.println("Costo habitación 101 (1 noche): " + costo3); // 132000
            hotel.reservarHabitacion(999, 1001, LocalDate.of(2027, 2, 1), LocalDate.of(2027, 2, 3));
        } catch (HabitacionOcupadaException e) {
            System.out.println("Habitación ocupada: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Suites con jacuzzi: " + hotel.contarSuitesConJacuzzi()); // 1

        System.out.println("Huéspedes antes: " + hotel.getHuespedes().size()); // 4
        hotel.eliminarHuespedesMenores();
        System.out.println("Huéspedes después: " + hotel.getHuespedes().size()); // 2
        for (Huesped h : hotel.getHuespedes()) {
            System.out.println(" - " + h.getNombre());
        }

        try {
            hotel.guardarHabitacionesBinario("habitaciones.dat");
            hotel.guardarHabitacionesTexto("habitaciones.txt");
            System.out.println("Archivos guardados");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
