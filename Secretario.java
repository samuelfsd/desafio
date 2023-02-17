import java.math.BigDecimal;
import java.time.LocalDate;

public class Secretario extends Funcionario implements FuncionarioComBeneficio {
  public Secretario(String nome, LocalDate dataContrato) {
    super(nome, dataContrato);
    this.bonificacaoAnual = new BigDecimal("1000");
    this.bonificacaoPorcentagem = new BigDecimal("0.2");
    this.salarioBase = new BigDecimal("7000");

  }

  @Override
  public BigDecimal getValorBeneficio(LocalDate atDate) {
    return getSalario(atDate).multiply(this.bonificacaoPorcentagem);
  }
}