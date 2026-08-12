package com.puj;

import enums.Banco;
import enums.TipoCuenta;

public class Cuenta {
    private String nombre;
    private TipoCuenta tipoCuenta;
    private Banco banco;

    public Cuenta(String nombre, TipoCuenta tipoCuenta, Banco banco) {
        this.nombre = nombre;
        this.tipoCuenta = tipoCuenta;
        this.banco = banco;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "nombre='" + nombre + '\'' +
                ", tipoCuenta=" + tipoCuenta +
                ", banco=" + banco +
                '}';
    }
}
