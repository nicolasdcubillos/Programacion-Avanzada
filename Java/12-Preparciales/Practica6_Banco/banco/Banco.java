package banco;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Banco {
    private String nombre;
    private ArrayList<Cuenta> cuentas;
    private ArrayList<Cliente> clientes;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.cuentas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void abrirCuenta(String tipoCuenta, String numero, Cliente titular) throws Exception {
        if (tipoCuenta.equalsIgnoreCase("ahorros")) {
            cuentas.add(new CuentaAhorros(numero, titular, 2));
        } else if (tipoCuenta.equalsIgnoreCase("corriente")) {
            cuentas.add(new CuentaCorriente(numero, titular, 500000, 10000));
        } else {
            throw new Exception("Tipo de cuenta desconocido: " + tipoCuenta);
        }
    }

    public void cerrarMes() {
        for (Cuenta c : cuentas) {
            c.aplicarCierreMensual();
        }
    }

    public int contarCuentasConSaldoMayor(int valor) {
        int cantidad = 0;
        for (Cuenta c : cuentas) {
            if (c.getSaldo() > valor) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int eliminarCuentasSaldoCero() {
        int eliminadas = 0;
        for (int i = cuentas.size() - 1; i >= 0; i--) {
            if (cuentas.get(i).getSaldo() == 0) {
                cuentas.remove(i);
                eliminadas++;
            }
        }
        return eliminadas;
    }

    public void guardarCuentasBinario(String ruta) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {
            out.writeObject(cuentas);
        }
    }

    public void guardarCuentasTexto(String ruta) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Cuenta c : cuentas) {
                String tipo;
                int adicional;
                if (c instanceof CuentaAhorros) {
                    tipo = "Ahorros";
                    adicional = ((CuentaAhorros) c).getTasaInteres();
                } else {
                    tipo = "Corriente";
                    adicional = ((CuentaCorriente) c).getSobregiroMaximo();
                }
                bw.write("Tipo de cuenta: " + tipo);
                bw.newLine();
                bw.write("Número: " + c.getNumero());
                bw.newLine();
                bw.write("Titular: " + c.getTitular().getNombre());
                bw.newLine();
                bw.write("Saldo: " + c.getSaldo());
                bw.newLine();
                bw.write("Transacciones: " + c.getTransacciones().size());
                bw.newLine();
                bw.write("Valor adicional: " + adicional);
                bw.newLine();
                bw.newLine();
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
