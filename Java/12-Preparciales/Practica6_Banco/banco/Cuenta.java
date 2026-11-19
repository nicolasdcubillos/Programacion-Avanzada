package banco;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;

    private String numero;
    private int saldo;
    private Cliente titular;
    private ArrayList<Transaccion> transacciones;

    public Cuenta(String numero, Cliente titular) {
        this.numero = numero;
        this.saldo = 0;
        this.titular = titular;
        this.transacciones = new ArrayList<>();
    }

    public abstract void retirar(int monto) throws SaldoInsuficienteException, Exception;

    public abstract void aplicarCierreMensual();

    // Suma el monto al saldo y registra la transacción
    public void depositar(int monto) throws Exception {
        if (monto <= 0) {
            throw new Exception("El monto a depositar debe ser mayor que cero");
        }
        saldo += monto;
        transacciones.add(new Transaccion(TipoTransaccion.DEPOSITO, monto));
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public ArrayList<Transaccion> getTransacciones() {
        return transacciones;
    }
}
