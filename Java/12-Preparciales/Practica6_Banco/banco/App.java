package banco;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco Andino");
        Cliente ana = new Cliente("1001", "Ana Gómez");
        Cliente luis = new Cliente("1002", "Luis Pérez");
        banco.getClientes().add(ana);
        banco.getClientes().add(luis);

        try {
            banco.abrirCuenta("ahorros", "A-001", ana);
            banco.abrirCuenta("corriente", "C-001", luis);
            banco.abrirCuenta("ahorros", "A-002", luis);
            banco.abrirCuenta("corriente", "C-002", ana);
            banco.abrirCuenta("platino", "P-001", ana); // tipo desconocido -> falla
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Cuentas abiertas: " + banco.getCuentas().size());

        Cuenta a1 = banco.getCuentas().get(0);
        Cuenta c1 = banco.getCuentas().get(1);
        try {
            a1.depositar(1000000);
            c1.depositar(200000);
            a1.depositar(-5000); // monto inválido -> falla
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            a1.retirar(300000);
            System.out.println("Saldo A-001 tras retirar 300000: " + a1.getSaldo());
            c1.retirar(500000);
            System.out.println("Saldo C-001 tras retirar 500000 (sobregiro): " + c1.getSaldo());
            a1.retirar(900000); // 700000 de saldo -> falla
        } catch (SaldoInsuficienteException e) {
            System.out.println("Excepción: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            c1.retirar(300000); // saldo -300000 + sobregiro 500000 = 200000 -> falla
        } catch (SaldoInsuficienteException e) {
            System.out.println("Excepción: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Cuentas con saldo mayor a 500000: " + banco.contarCuentasConSaldoMayor(500000));
        System.out.println("Cuentas eliminadas con saldo cero: " + banco.eliminarCuentasSaldoCero());
        System.out.println("Cuentas restantes: " + banco.getCuentas().size());

        banco.cerrarMes();
        for (Cuenta c : banco.getCuentas()) {
            System.out.println(c.getNumero() + " saldo tras cierre: " + c.getSaldo()
                    + " | transacciones: " + c.getTransacciones().size());
        }

        try {
            banco.guardarCuentasBinario("cuentas.dat");
            banco.guardarCuentasTexto("cuentas.txt");
            System.out.println("Archivos guardados");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
