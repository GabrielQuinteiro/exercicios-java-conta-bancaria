package Exercicio1;

import java.math.BigDecimal;

/*
* TODO: implementar método de pagar boleto e exibir infos
*/

public class ContaBancaria {
    private BigDecimal saldo;
    private final BigDecimal chequeEspecial;

    public ContaBancaria(BigDecimal depositoInicial) {
        this.saldo = depositoInicial;
        this.chequeEspecial = calcularChequeEspecial(depositoInicial);
    }

    private BigDecimal calcularChequeEspecial(BigDecimal depositoInicial) {
        BigDecimal valorEsperado = new BigDecimal("500.00");

        if (depositoInicial.compareTo(valorEsperado) <= 0) {
            return new BigDecimal("50.00");
        }

        // se depositoInicial > valorEsperado, retorna 50% do depositoInicial
        return depositoInicial.multiply(new BigDecimal("0.5"));
    }

    public boolean estaUtilizandoChequeEspecial() {
        return saldo.compareTo(BigDecimal.ZERO) < 0;
    }

    public BigDecimal chequeEspecialUtilizado() {
        if (estaUtilizandoChequeEspecial()) {
            return this.saldo.abs();
        }

        return BigDecimal.ZERO;
    }

    private void aplicarTaxaChequeEspecial(BigDecimal valorCobertura) {
        BigDecimal valorCobertoChequeEspecial;

        /* se saldo atual + valorCobertura for maior ou igual a zero */
        if (this.saldo.add(valorCobertura).compareTo(BigDecimal.ZERO) >= 0) {
            valorCobertoChequeEspecial = this.saldo.abs(); /* pega o valor abs do saldo */
        } else {
            valorCobertoChequeEspecial = valorCobertura;
        }

        BigDecimal taxaChequeEspecial = valorCobertoChequeEspecial.multiply(new BigDecimal("0.20")); /* taxa de 20% */

        this.saldo = this.saldo.subtract(taxaChequeEspecial);
    }

    public void depositarDinheiro(BigDecimal valorDepositado) {
        if (valorDepositado.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Valor depositado inválido");
        }

        if (estaUtilizandoChequeEspecial()) {
            aplicarTaxaChequeEspecial(valorDepositado);
        }

        this.saldo = this.saldo.add(valorDepositado);
    }

    public void sacarDinheiro(BigDecimal valorSacado) {
        if (valorSacado.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Valor para saque inválido.");
            return;
        }

        BigDecimal limiteDisponivel = consultarSaldo().add(consultarChequeEspecial());

        if (valorSacado.compareTo(limiteDisponivel) > 0) {
            System.out.println("Saldo insuficiente para saque.");
            return;
        }

        this.saldo = this.saldo.subtract(valorSacado);
    }

    public BigDecimal consultarSaldo() {
        return saldo;
    }

    public BigDecimal consultarChequeEspecial() {
        return chequeEspecial;
    }
}
