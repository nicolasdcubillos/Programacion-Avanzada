package com.puj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        Persona persona = new Persona("Ana María", 25);
        String archivoBinario = "persona.bin";
        String archivoTexto = "persona.txt";
        String archivoBinarioLista = "personas.bin";
        String archivoTextoLista = "personas.txt";

        // ======== SERIALIZAR / DESERIALIZAR UNA PERSONA (BINARIO) ========
        serializarPersona(persona, archivoBinario);
        Persona personaLeidaBinario = deserializarPersona(archivoBinario);

        if (personaLeidaBinario != null) {
            System.out.println("\nLeída desde archivo binario:");
            System.out.println(personaLeidaBinario);
        }

        // ======== GUARDAR / LEER UNA PERSONA (TEXTO) ========
        guardarPersonaEnTexto(persona, archivoTexto);
        Persona personaLeidaTexto = leerPersonaDesdeTexto(archivoTexto);

        if (personaLeidaTexto != null) {
            System.out.println("\nLeída desde archivo de texto:");
            System.out.println(personaLeidaTexto);
        }

        // ======== EJEMPLO CON VARIAS PERSONAS ========
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Carlos", 30));
        personas.add(new Persona("Laura", 22));
        personas.add(new Persona("Pedro", 28));

        // --- Guardar lista en binario ---
        serializarListaPersonas(personas, archivoBinarioLista);

        // --- Leer lista desde binario ---
        List<Persona> listaBinarioLeida = deserializarListaPersonas(archivoBinarioLista);
        System.out.println("\nPersonas leídas desde archivo binario:");
        if (listaBinarioLeida != null) {
            for (Persona p : listaBinarioLeida) {
                System.out.println(p);
            }
        }

        // --- Guardar lista en texto ---
        guardarListaPersonasEnTexto(personas, archivoTextoLista);

        // --- Leer lista desde texto ---
        List<Persona> listaTextoLeida = leerListaPersonasDesdeTexto(archivoTextoLista);
        System.out.println("\nPersonas leídas desde archivo de texto:");
        if (listaTextoLeida != null) {
            for (Persona p : listaTextoLeida) {
                System.out.println(p);
            }
        }
    }

    // ======== 1. SERIALIZAR EN BINARIO ========
    public static void serializarPersona(Persona persona, String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(persona);
            System.out.println("Objeto Persona serializado correctamente en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al serializar: " + e.getMessage());
        }
    }

    // ======== 2. DESERIALIZAR DESDE BINARIO ========
    public static Persona deserializarPersona(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Persona) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar: " + e.getMessage());
            return null;
        }
    }

    // ======== 3. GUARDAR EN ARCHIVO DE TEXTO ========
    public static void guardarPersonaEnTexto(Persona persona, String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(persona.getNombre() + "\n");
            writer.write(persona.getEdad() + "\n");
            System.out.println("Persona guardada como texto en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al escribir en texto: " + e.getMessage());
        }
    }

    // ======== 4. LEER DESDE ARCHIVO DE TEXTO ========
    public static Persona leerPersonaDesdeTexto(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String nombre = reader.readLine();
            int edad = Integer.parseInt(reader.readLine());
            return new Persona(nombre, edad);
        } catch (IOException e) {
            System.out.println("Error al leer desde texto: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: formato de edad inválido.");
        }
        return null;
    }

    // ======== 5. SERIALIZAR LISTA DE PERSONAS (BINARIO) ========
    public static void serializarListaPersonas(List<Persona> personas, String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(personas);
            System.out.println("Lista de personas serializada correctamente en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al serializar lista: " + e.getMessage());
        }
    }

    // ======== 6. DESERIALIZAR LISTA DE PERSONAS (BINARIO) ========
    public static List<Persona> deserializarListaPersonas(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Persona>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar lista: " + e.getMessage());
            return null;
        }
    }

    // ======== 7. GUARDAR LISTA DE PERSONAS EN TEXTO ========
    public static void guardarListaPersonasEnTexto(List<Persona> personas, String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Persona p : personas) {
                writer.write(p.getNombre() + "," + p.getEdad() + "\n");
            }
            System.out.println("Lista de personas guardada como texto en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al escribir lista en texto: " + e.getMessage());
        }
    }

    // ======== 8. LEER LISTA DE PERSONAS DESDE TEXTO ========
    public static List<Persona> leerListaPersonasDesdeTexto(String archivo) {
        List<Persona> personas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String nombre = partes[0];
                    int edad = Integer.parseInt(partes[1]);
                    personas.add(new Persona(nombre, edad));
                }
            }
            return personas;
        } catch (IOException e) {
            System.out.println("Error al leer lista desde texto: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: formato de edad inválido.");
        }
        return null;
    }
}
