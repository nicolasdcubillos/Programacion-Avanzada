package com.puj;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ControladorFechas {

    // ======== API moderna (java.time) ========

    // Obtener fecha actual
    public static LocalDate obtenerFechaActual() {
        return LocalDate.now();
    }

    // Obtener fecha y hora actual
    public static LocalDateTime obtenerFechaHoraActual() {
        return LocalDateTime.now();
    }

    // Formatear fecha LocalDate según formato
    public static String formatearFecha(LocalDate fecha, String formato) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return fecha.format(formatter);
    }

    // Convertir texto a LocalDate con formato
    public static LocalDate convertirTextoAFecha(String texto, String formato) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return LocalDate.parse(texto, formatter);
    }

    // Calcular días entre dos fechas
    public static long calcularDiferenciaDias(LocalDate inicio, LocalDate fin) {
        return ChronoUnit.DAYS.between(inicio, fin);
    }

    // Saber si una fecha es anterior a otra
    public static boolean esAntes(LocalDate fecha1, LocalDate fecha2) {
        return fecha1.isBefore(fecha2);
    }

    // Saber si una fecha es posterior a otra
    public static boolean esDespues(LocalDate fecha1, LocalDate fecha2) {
        return fecha1.isAfter(fecha2);
    }

    // Saber si dos fechas son iguales
    public static boolean esIgual(LocalDate fecha1, LocalDate fecha2) {
        return fecha1.isEqual(fecha2);
    }

    // ======== API antigua (java.util.Date) ========

    // Obtener fecha actual con Date
    public static Date obtenerFechaActualDate() {
        return new Date();
    }

    // Formatear un objeto Date con formato
    public static String formatearDate(Date fecha, String formato) {
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        return sdf.format(fecha);
    }

    // Convertir texto a Date
    public static Date convertirTextoADate(String texto, String formato) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        return sdf.parse(texto);
    }

    // Comparar fechas con Date
    public static boolean esAntes(Date f1, Date f2) {
        return f1.before(f2);
    }

    public static boolean esDespues(Date f1, Date f2) {
        return f1.after(f2);
    }

    public static boolean esIgual(Date f1, Date f2) {
        return f1.equals(f2);
    }

    // Diferencia en días usando Date
    public static long diferenciaEnDias(Date f1, Date f2) {
        long milisPorDia = 1000L * 60 * 60 * 24;
        long diferencia = f2.getTime() - f1.getTime();
        return diferencia / milisPorDia;
    }
}
