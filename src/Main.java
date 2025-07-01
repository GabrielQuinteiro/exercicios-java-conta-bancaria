import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal("500.00"));

        contaBancaria.depositarDinheiro(new BigDecimal("10.00"));
        System.out.println(contaBancaria.consultarSaldo());
        contaBancaria.sacarDinheiro(new BigDecimal("530.00"));
        System.out.println(contaBancaria.consultarSaldo());
        contaBancaria.sacarDinheiro(new BigDecimal("30.00"));
        System.out.println(contaBancaria.consultarSaldo());

    }
}