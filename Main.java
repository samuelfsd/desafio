import java.math.BigDecimal;
import java.time.LocalDate;

class Main {
  public static void main(String[] args) {
    FolhaPagamento folpag = new FolhaPagamento();

    BigDecimal valorTotalFuncionarios =
            folpag.valorPagoParaFuncionariosComBeneficios(folpag.getFuncionarios(), LocalDate.now());
    System.out.println("valorTotalFuncionarios: " + valorTotalFuncionarios);

    BigDecimal valorTotalSemBeneficiosFuncionarios =
            folpag.valorPagoParaFuncionariosSemBenficios(folpag.getFuncionarios(), LocalDate.now());
    System.out.println("valorTotalSemBeneficiosFuncionarios: " + valorTotalSemBeneficiosFuncionarios);

    BigDecimal valorDeBeneficiosNoMes =
            folpag.totalBeneficiosPagos(folpag.getFuncionariosComBeneficio(), LocalDate.now());
    System.out.println("valorDeBeneficiosNoMes: " + valorDeBeneficiosNoMes);

    Funcionario funcionarioComMaiorSalarioNoMes =
            folpag.funcionarioComMaiorSalarioNoMes(folpag.getFuncionarios(), LocalDate.now());
    System.out.println("funcionarioComMaiorSalarioNoMes: " + funcionarioComMaiorSalarioNoMes.getNome());

    Funcionario funcionarioComMaiorValorDeBeneficio =
            folpag.valorPagoBeneficioMaisAltoNoMes(folpag.getFuncionariosComBeneficio(), LocalDate.now());
    System.out.println("funcionarioComMaiorValorDeBeneficio: " + funcionarioComMaiorValorDeBeneficio.getNome());

    Vendedor vendedorComMaisVendas =
            folpag.vendedorComMaisVendasMes(folpag.getVendedores(), LocalDate.of(2021,12,1));
    System.out.println("vendedorComMaisVendas: " + vendedorComMaisVendas.getNome());

  }
}