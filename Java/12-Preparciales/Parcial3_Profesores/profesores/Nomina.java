package profesores;

import java.util.ArrayList;
import java.util.List;

// 2.4
public class Nomina {
    private ArrayList<Profesor> profesores;

    public Nomina() {
        this.profesores = new ArrayList<>();
    }

    public void agregarProfesorPlanta(String nombre, String correo, String categoria, int salario) {
        profesores.add(new ProfesorPlanta(nombre, correo, categoria, salario));
    }

    public void agregarProfesorCatedra(String nombre, String correo, int tarifa, int horasDictadas) {
        profesores.add(new ProfesorCatedra(nombre, correo, tarifa, horasDictadas));
    }

    public void eliminarProfesor(String correo) {
        for (int i = profesores.size() - 1; i >= 0; i--) {
            if (profesores.get(i).getCorreo().equals(correo)) {
                profesores.remove(i);
            }
        }
    }

    // Polimorfismo: cada profesor responde con su propio imprimirSalario()
    public List<String> imprimirNomina() {
        List<String> resultado = new ArrayList<>();
        for (Profesor p : profesores) {
            resultado.add(p.imprimirSalario());
        }
        return resultado;
    }
}
