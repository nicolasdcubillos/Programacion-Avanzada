package com.puj;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        System.out.println("===== MÉTODOS DE LA CLASE STRING =====\n");

        // Crear una cadena base
        String texto = "Programación en Java";
        System.out.println("Texto original: " + texto);

        // Longitud del texto
        System.out.println("\n1. length(): " + texto.length());

        // Convertir a mayúsculas y minúsculas
        System.out.println("2. toUpperCase(): " + texto.toUpperCase());
        System.out.println("3. toLowerCase(): " + texto.toLowerCase());

        // Obtener un carácter específico
        System.out.println("4. charAt(0): " + texto.charAt(0)); // primer carácter

        // Subcadena (desde-hasta)
        System.out.println("5. substring(0, 12): " + texto.substring(0, 12)); // "Programación"

        // Buscar una palabra o carácter
        System.out.println("6. indexOf('Java'): " + texto.indexOf("Java"));
        System.out.println("7. contains('en'): " + texto.contains("en"));

        // Comparar cadenas
        String otra = "programación en java";
        System.out.println("8. equals(otra): " + texto.equals(otra)); // sensible a mayúsculas
        System.out.println("9. equalsIgnoreCase(otra): " + texto.equalsIgnoreCase(otra)); // ignora mayúsculas

        // Reemplazar texto
        System.out.println("10. replace('Java', 'Python'): " + texto.replace("Java", "Python"));

        // Quitar espacios en los extremos
        String conEspacios = "   Hola mundo   ";
        System.out.println("\nTexto con espacios: '" + conEspacios + "'");
        System.out.println("11. trim(): '" + conEspacios.trim() + "'");

        // Dividir una cadena
        String frase = "uno,dos,tres,cuatro";
        String[] partes = frase.split(",");
        System.out.println("\n12. split(\",\"): ");
        for (String p : partes) {
            System.out.println(" - " + p);
        }

        // Reemplazar todos los espacios por guiones bajos
        System.out.println("\n13. replaceAll(\" \", \"_\"): " + texto.replaceAll(" ", "_"));

        // Comprobar prefijo y sufijo
        System.out.println("\n14. startsWith('Pro'): " + texto.startsWith("Pro"));
        System.out.println("15. endsWith('Java'): " + texto.endsWith("Java"));

        // Convertir números o caracteres a String
        int numero = 123;
        System.out.println("\n16. String.valueOf(123): " + String.valueOf(numero));

        // Concatenar cadenas
        String saludo = "Hola";
        System.out.println("17. concat(): " + saludo.concat(" mundo"));

        // Comparar orden lexicográfico
        System.out.println("\n18. compareTo('Programación en C++'): " + texto.compareTo("Programación en C++"));
    }
}
