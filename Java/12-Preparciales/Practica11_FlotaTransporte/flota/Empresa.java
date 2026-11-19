package flota;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Conductor> conductores;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.vehiculos = new ArrayList<>();
        this.conductores = new ArrayList<>();
    }

    public Vehiculo buscarVehiculo(String placa) throws Exception {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        throw new Exception("No existe el vehículo con placa " + placa);
    }

    public double costoViaje(String placa, int km) throws Exception {
        Vehiculo v = buscarVehiculo(placa);
        return v.calcularCostoViaje(km);
    }

    public void asignarConductor(String placa, String cedula) throws VehiculoNoDisponibleException, Exception {
        Vehiculo vehiculo = buscarVehiculo(placa);
        Conductor encontrado = null;
        for (Conductor c : conductores) {
            if (c.getCedula().equals(cedula)) {
                encontrado = c;
            }
        }
        if (encontrado == null) {
            throw new Exception("No existe el conductor con cédula " + cedula);
        }
        if (vehiculo.getEstado() != Estado.DISPONIBLE) {
            throw new VehiculoNoDisponibleException("El vehículo " + placa + " no está disponible: " + vehiculo.getEstado());
        }
        vehiculo.setConductor(encontrado);
        vehiculo.setEstado(Estado.EN_RUTA);
    }

    public int contarPorEstado(Estado estado) {
        int cantidad = 0;
        for (Vehiculo v : vehiculos) {
            if (v.getEstado() == estado) {
                cantidad++;
            }
        }
        return cantidad;
    }

    // Elimina los conductores cuya licencia vence antes de la fecha dada y retorna cuántos eliminó
    public int eliminarLicenciasVencidas(LocalDate fecha) {
        int eliminados = 0;
        for (int i = conductores.size() - 1; i >= 0; i--) {
            if (conductores.get(i).getVencimientoLicencia().isBefore(fecha)) {
                conductores.remove(i);
                eliminados++;
            }
        }
        return eliminados;
    }

    public void guardarBinario(String ruta) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {
            out.writeObject(vehiculos);
            out.writeObject(conductores);
        }
    }

    public void guardarTexto(String ruta) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Vehiculo v : vehiculos) {
                String tipo;
                int adicional;
                if (v instanceof Bus) {
                    tipo = "Bus";
                    adicional = ((Bus) v).getPasajeros();
                } else {
                    tipo = "Camion";
                    adicional = ((Camion) v).getToneladas();
                }
                String nombreConductor = "Sin conductor";
                if (v.getConductor() != null) {
                    nombreConductor = v.getConductor().getNombre();
                }
                bw.write("Tipo de vehículo: " + tipo);
                bw.newLine();
                bw.write("Placa: " + v.getPlaca());
                bw.newLine();
                bw.write("Estado: " + v.getEstado());
                bw.newLine();
                bw.write("Valor adicional: " + adicional);
                bw.newLine();
                bw.write("Conductor: " + nombreConductor);
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

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public ArrayList<Conductor> getConductores() {
        return conductores;
    }
}
