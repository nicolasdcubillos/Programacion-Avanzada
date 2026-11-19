package robots;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Arena {
    private String ciudad;
    private int energia;
    private ArrayList<Robot> equipo;

    public Arena(String ciudad, int energia) {
        this.ciudad = ciudad;
        this.energia = energia;
        this.equipo = new ArrayList<>();
    }

    public void anadirRobot(String tipoRobot) throws EnergiaInsuficienteException, Exception {
        if (tipoRobot.equalsIgnoreCase("combate")) {
            if (energia < 8) {
                throw new EnergiaInsuficienteException("Energía insuficiente para un robot de combate");
            }
            equipo.add(new RobotCombate(12, 100, 18, 10));
            energia -= 8;
        } else if (tipoRobot.equalsIgnoreCase("volador")) {
            if (energia < 12) {
                throw new EnergiaInsuficienteException("Energía insuficiente para un robot volador");
            }
            equipo.add(new RobotVolador(20, 150, 45));
            energia -= 12;
        } else {
            throw new Exception("Tipo de robot desconocido: " + tipoRobot);
        }
    }

    public int cantidadVoladoresPoderosos() {
        int cantidad = 0;
        for (Robot r : equipo) {
            if (r instanceof RobotVolador && ((RobotVolador) r).getDanoLaser() > 40) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public void guardarRobotsBinario(String ruta) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {
            out.writeObject(equipo);
        }
    }

    public void guardarRobotsTexto(String ruta) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Robot r : equipo) {
                String tipo;
                int adicional;
                if (r instanceof RobotVolador) {
                    tipo = "Volador";
                    adicional = ((RobotVolador) r).getDanoLaser();
                } else {
                    tipo = "Combate";
                    adicional = ((RobotCombate) r).getEscudo().getResistencia();
                }
                bw.write("Tipo de robot: " + tipo);
                bw.newLine();
                bw.write("Potencia base: " + r.getPotenciaBase());
                bw.newLine();
                bw.write("Batería: " + r.getBateria());
                bw.newLine();
                bw.write("Valor adicional: " + adicional);
                bw.newLine();
                bw.newLine();
            }
        }
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public ArrayList<Robot> getEquipo() {
        return equipo;
    }
}
