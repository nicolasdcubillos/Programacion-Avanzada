package hotel;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Hotel {
    private String nombre;
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Huesped> huespedes;

    public Hotel(String nombre) {
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
        this.huespedes = new ArrayList<>();
    }

    public int reservarHabitacion(int numeroHabitacion, int documento, LocalDate entrada, LocalDate salida)
            throws HabitacionOcupadaException, Exception {
        if (!salida.isAfter(entrada)) {
            throw new Exception("La fecha de salida debe ser posterior a la de entrada");
        }

        Habitacion habitacion = null;
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numeroHabitacion) {
                habitacion = h;
            }
        }
        if (habitacion == null) {
            throw new Exception("No existe la habitación " + numeroHabitacion);
        }

        Huesped huesped = null;
        for (Huesped hu : huespedes) {
            if (hu.getDocumento() == documento) {
                huesped = hu;
            }
        }
        if (huesped == null) {
            throw new Exception("No existe el huésped con documento " + documento);
        }

        // Dos reservas se cruzan si cada una empieza antes de que termine la otra
        for (Reserva r : habitacion.getReservas()) {
            if (entrada.isBefore(r.getFechaSalida()) && salida.isAfter(r.getFechaEntrada())) {
                throw new HabitacionOcupadaException("La habitación " + numeroHabitacion + " está ocupada entre "
                        + r.getFechaEntrada() + " y " + r.getFechaSalida());
            }
        }

        Reserva reserva = new Reserva(huesped, entrada, salida);
        habitacion.getReservas().add(reserva);
        return habitacion.calcularCosto(reserva.calcularNoches());
    }

    public int contarSuitesConJacuzzi() {
        int cantidad = 0;
        for (Habitacion h : habitaciones) {
            if (h instanceof Suite && ((Suite) h).isJacuzzi()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public void eliminarHuespedesMenores() {
        LocalDate hoy = LocalDate.now();
        for (int i = huespedes.size() - 1; i >= 0; i--) {
            int edad = Period.between(huespedes.get(i).getFechaNacimiento(), hoy).getYears();
            if (edad < 18) {
                huespedes.remove(i);
            }
        }
    }

    public void guardarHabitacionesBinario(String ruta) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {
            out.writeObject(habitaciones);
        }
    }

    public void guardarHabitacionesTexto(String ruta) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Habitacion h : habitaciones) {
                String tipo;
                int servicios;
                if (h instanceof Suite) {
                    tipo = "Suite";
                    servicios = ((Suite) h).getServiciosIncluidos();
                } else {
                    tipo = "Sencilla";
                    servicios = 0;
                }
                bw.write("Tipo de habitación: " + tipo);
                bw.newLine();
                bw.write("Número: " + h.getNumero());
                bw.newLine();
                bw.write("Tipo de cama: " + h.getTipoCama());
                bw.newLine();
                bw.write("Precio por noche: " + h.getPrecioNoche());
                bw.newLine();
                bw.write("Servicios incluidos: " + servicios);
                bw.newLine();
                bw.write("Reservas: " + h.getReservas().size());
                bw.newLine();
                bw.newLine();
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public ArrayList<Huesped> getHuespedes() {
        return huespedes;
    }
}
