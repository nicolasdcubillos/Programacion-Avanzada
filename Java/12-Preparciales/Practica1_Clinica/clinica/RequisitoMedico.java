package clinica;

import java.io.Serializable;

public class RequisitoMedico implements Serializable {
    private static final long serialVersionUID = 1L;

    private String descripcion;

    public RequisitoMedico(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
