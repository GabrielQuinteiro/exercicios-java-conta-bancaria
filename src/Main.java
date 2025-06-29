import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal("501.00"));

        contaBancaria.depositarDinheiro(new BigDecimal("10.00"));
        System.out.println(contaBancaria.consultarSaldo());
        contaBancaria.sacarDinheiro(new BigDecimal("5.00"));
        System.out.println(contaBancaria.consultarSaldo());


    }
}