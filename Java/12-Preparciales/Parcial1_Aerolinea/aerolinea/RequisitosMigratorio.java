package aerolinea;

import java.io.Serializable;

public class RequisitosMigratorio implements Serializable {
    private static final long serialVersionUID = 1L;

    private String descripcion;

    public RequisitosMigratorio(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
