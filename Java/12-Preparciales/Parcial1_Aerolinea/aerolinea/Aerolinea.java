package aerolinea;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Aerolinea implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private ArrayList<Vuelo> vuelos;

    public Aerolinea(String nombre) {
        this.nombre = nombre;
        this.vuelos = new ArrayList<>();
    }

    public void agregarVuelo(Vuelo vuelo) {
        vuelos.add(vuelo);
    }

    // Método auxiliar que el enunciado permite suponer
    public Vuelo buscarVuelo(int numVuelo) {
        for (Vuelo v : vuelos) {
            if (v.getNumeroVuelo() == numVuelo) {
                return v;
            }
        }
        return null;
    }

    // Agrega un pasajero al vuelo; si ya existe, lanza excepción
    public void agregarPasajero(int numeroVuelo, String nombre, int id,
                                LocalDate fechaNacimiento, int numeroSilla) throws PasajeroExistenteException {
        Vuelo vuelo = buscarVuelo(numeroVuelo);
        if (vuelo == null) {
            throw new IllegalArgumentException("No existe el vuelo " + numeroVuelo);
        }
        if (vuelo.buscarPasajero(nombre) != null) {
            throw new PasajeroExistenteException("El pasajero " + nombre + " ya está en el vuelo " + numeroVuelo);
        }
        vuelo.agregarPasajero(new Pasajero(nombre, id, fechaNacimiento, numeroSilla));
    }

    // Vuelos internacionales que tienen el requisito migratorio dado
    public ArrayList<String> vuelosConRestricciones(String restriccion) {
        ArrayList<String> resultado = new ArrayList<>();
        for (Vuelo v : vuelos) {
            if (v instanceof Internacional) {
                Internacional inter = (Internacional) v;
                if (inter.tieneRequisito(restriccion)) {
                    resultado.add(nombre + "-" + v.getNumeroVuelo() + "-" + v.getOrigen() + "-" + v.getDestino());
                }
            }
        }
        return resultado;
    }

    // Reporte en vuelosOrigen.txt: <Tipo>-<Aerolinea>-<numVuelo>-<origen>-<destino>-<info específica>
    public void generarReporte(String origen) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("vuelosOrigen.txt"))) {
            for (Vuelo v : vuelos) {
                if (v.getOrigen().equalsIgnoreCase(origen)) {
                    String tipo = (v instanceof Nacional) ? "Nacional" : "Internacional";
                    bw.write("<" + tipo + ">-<" + nombre + "-" + v.getNumeroVuelo() + "-" + v.getOrigen()
                            + "-" + v.getDestino() + "-" + v.descripcionEspecifica() + ">");
                    bw.newLine();
                }
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }
}
