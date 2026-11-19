package banco;

public class CuentaAhorros extends Cuenta {
    private static final long serialVersionUID = 1L;

    private int tasaInteres;

    public CuentaAhorros(String numero, Cliente titular, int tasaInteres) {
        super(numero, titular);
        this.tasaInteres = tasaInteres;
    }

    // No permite sobregiro: el monto no puede superar el saldo
    @Override
    public void retirar(int monto) throws SaldoInsuficienteException, Exception {
        if (monto <= 0) {
            throw new Exception("El monto a retirar debe ser mayor que cero");
        }
        if (monto > getSaldo()) {
            throw new SaldoInsuficienteException("Saldo insuficiente en la cuenta de ahorros " + getNumero());
        }
        setSaldo(getSaldo() - monto);
        getTransacciones().add(new Transaccion(TipoTransaccion.RETIRO, monto));
    }

    // Abona el interés mensual (saldo * tasaInteres / 100) si es mayor que cero
    @Override
    public void aplicarCierreMensual() {
        int interes = getSaldo() * tasaInteres / 100;
        if (interes > 0) {
            setSaldo(getSaldo() + interes);
            getTransacciones().add(new Transaccion(TipoTransaccion.DEPOSITO, interes));
        }
    }

    public int getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(int tasaInteres) {
        this.tasaInteres = tasaInteres;
    }
}
