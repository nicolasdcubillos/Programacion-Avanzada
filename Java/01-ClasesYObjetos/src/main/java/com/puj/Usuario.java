package com.puj;

public class Usuario {
    private String nombre;
    private Integer edad;
    private String apellido;
    private Integer codigo;

    public Usuario(String nombre, Integer edad, String apellido, Integer codigo) {
        this.nombre = nombre;
        this.edad = edad;
        this.apellido = apellido;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", apellido='" + apellido + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}
