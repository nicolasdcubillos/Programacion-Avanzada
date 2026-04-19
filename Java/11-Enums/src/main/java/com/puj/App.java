package com.puj;

import enums.*;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Ingrese el nombre de la cuenta: ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese el tipo de cuenta. Posibles valores: ");
            for (TipoCuenta tipoCuenta : TipoCuenta.values()) {
                System.out.print(tipoCuenta + " ");
            }
            System.out.print(": ");
            String tipoCuentaString = sc.nextLine();
            TipoCuenta tipoCuenta = Enum.valueOf(TipoCuenta.class, tipoCuentaString);

            System.out.print("Ingrese el banco. Posibles valores: ");
            for (Banco banco : Banco.values()) {
                System.out.print(banco + " ");
            }
            System.out.print(": ");
            String bancoString = sc.nextLine();
            Banco banco = Enum.valueOf(Banco.class, bancoString);

            Cuenta cuenta = new Cuenta(nombre, tipoCuenta, banco);
            System.out.println("Cuenta creada: " + cuenta.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("No se encontro el valor en el enum: " + e.getMessage());
        }
    }
}
