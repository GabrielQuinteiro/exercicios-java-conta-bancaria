package Exercicio1;

import java.math.BigDecimal;

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

    public void depositarDinheiro(BigDecimal valorDepositado) {
        this.saldo = this.saldo.add(valorDepositado);
    }

    public void sacarDinheiro(BigDecimal valorSacado) {
        BigDecimal limiteDisponivel = consultarSaldo().add(consultarChequeEspecial());

        if (valorSacado.compareTo(new BigDecimal("0")) <= 0) {
            System.out.println("Valor para saque inválido.");
            return;
        }

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
