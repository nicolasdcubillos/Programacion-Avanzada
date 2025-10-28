package com.puj;

import java.util.*;

public class App 
{
    public static void main(String[] args) {

        // ======== LIST (ArrayList y LinkedList) ========
        // Permite elementos duplicados y mantiene el orden de inserción.
        System.out.println("===== LIST =====");

        List<String> listaNombres = new ArrayList<>();
        listaNombres.add("Ana");
        listaNombres.add("Pedro");
        listaNombres.add("Camila");
        listaNombres.add("Ana"); // permite duplicados

        System.out.println("Lista original: " + listaNombres);

        listaNombres.remove("Pedro"); // elimina por valor
        System.out.println("Después de eliminar 'Pedro': " + listaNombres);

        System.out.println("Elemento en posición 1: " + listaNombres.get(1));
        System.out.println("¿Contiene 'Camila'? " + listaNombres.contains("Camila"));

        // También podemos usar LinkedList (similar, pero más eficiente para insertar en el medio)
        LinkedList<String> listaEnlazada = new LinkedList<>(listaNombres);
        listaEnlazada.addFirst("Inicio");
        listaEnlazada.addLast("Final");
        System.out.println("LinkedList: " + listaEnlazada);


        // ======== SET (HashSet y TreeSet) ========
        // No permite duplicados y no garantiza orden (HashSet)
        // TreeSet sí mantiene orden alfabético o natural
        System.out.println("\n===== SET =====");

        Set<String> conjunto = new HashSet<>();
        conjunto.add("Colombia");
        conjunto.add("México");
        conjunto.add("Argentina");
        conjunto.add("Colombia"); // duplicado ignorado

        System.out.println("HashSet (sin orden): " + conjunto);
        conjunto.remove("México");
        System.out.println("Después de eliminar 'México': " + conjunto);

        // TreeSet ordena automáticamente
        Set<String> conjuntoOrdenado = new TreeSet<>(conjunto);
        System.out.println("TreeSet (ordenado): " + conjuntoOrdenado);


        // ======== MAP (HashMap y TreeMap) ========
        // Estructura clave-valor. No puede haber claves duplicadas.
        System.out.println("\n===== MAP =====");

        Map<String, Integer> edades = new HashMap<>();
        edades.put("Ana", 20);
        edades.put("Pedro", 25);
        edades.put("Camila", 22);
        edades.put("Pedro", 30); // sobrescribe el valor anterior

        System.out.println("HashMap: " + edades);
        System.out.println("Edad de Camila: " + edades.get("Camila"));

        edades.remove("Ana");
        System.out.println("Después de eliminar 'Ana': " + edades);

        System.out.println("Claves: " + edades.keySet());
        System.out.println("Valores: " + edades.values());

        // TreeMap ordena por clave alfabéticamente
        Map<String, Integer> mapaOrdenado = new TreeMap<>(edades);
        System.out.println("TreeMap (ordenado): " + mapaOrdenado);


        // ======== ITERACIÓN ========
        System.out.println("\n===== RECORRER COLECCIONES =====");

        System.out.println("Recorriendo ArrayList con for-each:");
        for (String nombre : listaNombres) {
            System.out.println(" - " + nombre);
        }

        System.out.println("\nRecorriendo Set con Iterator:");
        Iterator<String> it = conjunto.iterator();
        while (it.hasNext()) {
            System.out.println(" * " + it.next());
        }

        System.out.println("\nRecorriendo Map (clave-valor):");
        for (Map.Entry<String, Integer> entry : edades.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
