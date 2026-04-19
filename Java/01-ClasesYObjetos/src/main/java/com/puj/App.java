package com.puj;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Integer opcion;
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca("Biblioteca PUJ");
        do {
            System.out.println("1. Crear libro");
            System.out.println("2. Crear usuario");
            System.out.println("3. Listar libros");
            System.out.println("4. Listar usuarios");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del autor");
                    String nombreAutor = sc.nextLine();
                    System.out.println("Ingrese el apellido del autor");
                    String apellidoAutor = sc.nextLine();
                    System.out.println("Ingrese el la edad del autor");
                    Integer edadAutor = sc.nextInt();
                    Autor autor = new Autor(nombreAutor, edadAutor, apellidoAutor);

                    sc.nextLine();
                    System.out.println("Ingrese el titulo del libro");
                    String tituloLibro = sc.nextLine();
                    System.out.println("Ingrese el genero del libro");
                    String generoLibro = sc.nextLine();
                    Libro libro = new Libro(tituloLibro, generoLibro, autor);
                    biblioteca.agregarLibro(libro);
                    System.out.println("Libro agregado con exito.");
                    break;
                }

                case 2: {
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del usuario");
                    String nombreUsuario = sc.nextLine();
                    System.out.println("Ingrese el apellido del usuario");
                    String apellidoUsuario = sc.nextLine();
                    System.out.println("Ingrese la edad del usuario");
                    Integer edadUsuario = sc.nextInt();
                    System.out.println("Ingrese el codigo del usuario");
                    Integer codigoUsuario = sc.nextInt();
                    Usuario usuario = new Usuario(nombreUsuario, edadUsuario, apellidoUsuario, codigoUsuario);
                    biblioteca.agregarUsuario(usuario);
                    break;
                }

                case 3: {
                    for (Libro libro : biblioteca.getLibros()) {
                        System.out.println(libro.toString());
                    }
                    break;
                }

                case 4: {
                    for (Usuario usuario : biblioteca.getUsuarios()) {
                        System.out.println(usuario.toString());
                    }
                    break;
                }

            }
        } while (opcion != 0);
    }
}
