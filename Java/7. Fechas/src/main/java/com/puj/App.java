package com.puj;

import java.time.LocalDate;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        try {
            // --- API moderna ---
            LocalDate hoy = ControladorFechas.obtenerFechaActual();
            LocalDate navidad = ControladorFechas.convertirTextoAFecha("25-12-2025", "dd-MM-yyyy");

            System.out.println("Fecha actual: " + hoy);
            System.out.println("Navidad: " + navidad);
            System.out.println("¿Hoy es antes que Navidad? " + ControladorFechas.esAntes(hoy, navidad));
            System.out.println("¿Hoy es después que Navidad? " + ControladorFechas.esDespues(hoy, navidad));
            System.out.println("¿Son iguales? " + ControladorFechas.esIgual(hoy, navidad));

            long diasRestantes = ControladorFechas.calcularDiferenciaDias(hoy, navidad);
            System.out.println("Días hasta Navidad: " + diasRestantes);

            // --- API antigua ---
            Date fechaActualDate = ControladorFechas.obtenerFechaActualDate();
            Date finDeAno = ControladorFechas.convertirTextoADate("31/12/2025", "dd/MM/yyyy");

            System.out.println("\nUsando java.util.Date:");
            System.out.println("Fecha actual: " + ControladorFechas.formatearDate(fechaActualDate, "dd-MM-yyyy HH:mm:ss"));
            System.out.println("Fin de año: " + ControladorFechas.formatearDate(finDeAno, "dd-MM-yyyy"));

            System.out.println("¿Actual es antes de fin de año? " + ControladorFechas.esAntes(fechaActualDate, finDeAno));
            System.out.println("¿Actual es después de fin de año? " + ControladorFechas.esDespues(fechaActualDate, finDeAno));

            long diasDate = ControladorFechas.diferenciaEnDias(fechaActualDate, finDeAno);
            System.out.println("Días hasta fin de año: " + diasDate);

        } catch (Exception e) {
            System.out.println("Error al procesar fechas: " + e.getMessage());
        } finally {
            System.out.println("Ejecución finalizada.");
        }
    }
}
