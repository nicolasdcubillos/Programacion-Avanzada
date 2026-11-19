package universidad;

import java.io.IOException;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Universidad uni = new Universidad("Universidad Nacional");

        Estudiante ana = new EstudiantePregrado("Ana Gómez", "P001", LocalDate.of(2023, 2, 1),
                Modalidad.PRESENCIAL, "Ingeniería de Sistemas");
        Estudiante bruno = new EstudiantePregrado("Bruno Díaz", "P002", LocalDate.of(2022, 8, 15),
                Modalidad.VIRTUAL, "Matemáticas");
        Estudiante carla = new EstudiantePosgrado("Carla Ruiz", "G001", LocalDate.of(2024, 1, 20),
                Modalidad.PRESENCIAL, "Inteligencia Artificial");
        Estudiante diego = new EstudiantePregrado("Diego Mora", "P003", LocalDate.of(2021, 2, 10),
                Modalidad.PRESENCIAL, "Economía");
        Estudiante elena = new EstudiantePosgrado("Elena Paz", "G002", LocalDate.of(2024, 8, 5),
                Modalidad.VIRTUAL, "Redes");
        uni.getEstudiantes().add(ana);
        uni.getEstudiantes().add(bruno);
        uni.getEstudiantes().add(carla);
        uni.getEstudiantes().add(diego);
        uni.getEstudiantes().add(elena);

        try {
            ana.inscribirMateria("Programación Avanzada", 4, 4.5);
            ana.inscribirMateria("Cálculo", 3, 4.2);
            ana.inscribirMateria("Física", 4, 4.8);
            bruno.inscribirMateria("Álgebra", 4, 2.0);
            bruno.inscribirMateria("Química", 3, 2.5);
            carla.inscribirMateria("Minería de Datos", 5, 4.4);
            carla.inscribirMateria("Aprendizaje de Máquina", 4, 4.0);
            diego.inscribirMateria("Ética", 2, 3.5);
            diego.inscribirMateria("Estadística", 3, 3.0);
            elena.inscribirMateria("Seminario", 3, 2.8);
            System.out.println("Materias inscritas correctamente");

            ana.inscribirMateria("Inglés", 8, 4.0); // 11 + 8 = 19 > 18 -> falla
        } catch (CreditosExcedidosException e) {
            System.out.println("Créditos excedidos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            ana.inscribirMateria("Deportes", 0, 5.0); // créditos inválidos -> falla
        } catch (CreditosExcedidosException e) {
            System.out.println("Créditos excedidos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        for (Estudiante e : uni.getEstudiantes()) {
            System.out.println(e.getNombre() + " | promedio: " + e.calcularPromedio()
                    + " | matrícula: " + e.calcularMatricula());
        }
        System.out.println("Estudiantes destacados (promedio > 4.0): " + uni.contarEstudiantesDestacados());

        int eliminados = uni.eliminarEstudiantesBajoRendimiento();
        System.out.println("Estudiantes eliminados (promedio < 3.0): " + eliminados);
        System.out.println("Estudiantes restantes: " + uni.getEstudiantes().size());

        try {
            uni.guardarEstudiantesBinario("estudiantes.dat");
            uni.guardarEstudiantesTexto("estudiantes.txt");
            System.out.println("Archivos guardados");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
