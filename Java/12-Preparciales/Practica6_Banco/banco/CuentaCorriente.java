package banco;

public class CuentaCorriente extends Cuenta {
    private static final long serialVersionUID = 1L;

    private int sobregiroMaximo;
    private int cuotaManejo;

    public CuentaCorriente(String numero, Cliente titular, int sobregiroMaximo, int cuotaManejo) {
        super(numero, titular);
        this.sobregiroMaximo = sobregiroMaximo;
        this.cuotaManejo = cuotaManejo;
    }

    // Permite dejar el saldo negativo hasta -sobregiroMaximo
    @Override
    public void retirar(int monto) throws SaldoInsuficienteException, Exception {
        if (monto <= 0) {
            throw new Exception("El monto a retirar debe ser mayor que cero");
        }
        if (monto > getSaldo() + sobregiroMaximo) {
            throw new SaldoInsuficienteException("Sobregiro excedido en la cuenta corriente " + getNumero());
        }
        setSaldo(getSaldo() - monto);
        getTransacciones().add(new Transaccion(TipoTransaccion.RETIRO, monto));
    }

    // Descuenta la cuota de manejo aunque el saldo quede por debajo del sobregiro
    @Override
    public void aplicarCierreMensual() {
        setSaldo(getSaldo() - cuotaManejo);
        getTransacciones().add(new Transaccion(TipoTransaccion.RETIRO, cuotaManejo));
    }

    public int getSobregiroMaximo() {
        return sobregiroMaximo;
    }

    public void setSobregiroMaximo(int sobregiroMaximo) {
        this.sobregiroMaximo = sobregiroMaximo;
    }

    public int getCuotaManejo() {
        return cuotaManejo;
    }

    public void setCuotaManejo(int cuotaManejo) {
        this.cuotaManejo = cuotaManejo;
    }
}
