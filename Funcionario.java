import java.time.LocalDate;
import java.math.BigDecimal;
import java.time.Period;

public abstract class Funcionario {
  protected BigDecimal bonificacaoAnual;
  protected BigDecimal bonificacaoPorcentagem;
  protected BigDecimal salarioBase;
  protected String nome;
  protected LocalDate dataContrato;

  public Funcionario(String nome, LocalDate dataContrato) {
    this.bonificacaoAnual = new BigDecimal("0");
    this.bonificacaoPorcentagem = new BigDecimal("0");
    this.nome = nome;
    this.dataContrato = dataContrato;
  }

  public BigDecimal getSalario(LocalDate atDate){
    Period intervalPeriod = Period.between(dataContrato, atDate);
    return salarioBase.add(bonificacaoAnual.multiply(
                new BigDecimal(String.valueOf(intervalPeriod.getYears()))));
  }
  
  public void setSalario(BigDecimal salarioBase) {
    this.salarioBase = salarioBase;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public LocalDate getDataContrato() {
    return dataContrato;
  }

  public void setDataContrato(LocalDate dataContrato) {
    this.dataContrato = dataContrato;
  }

  public BigDecimal getSalarioComBeneficio(LocalDate atDate){
      BigDecimal salario = getSalario(atDate);
      salario = salario.add(salario.multiply(bonificacaoPorcentagem));
      return salario;
  }

  @Override
  public String toString() {
    return "Funcionario{" +
            "bonificacaoAnual=" + bonificacaoAnual +
            ", bonificacaoPorcentagem=" + bonificacaoPorcentagem +
            ", salarioBase=" + salarioBase +
            ", nome='" + nome + '\'' +
            ", dataContrato=" + dataContrato +
            '}';
  }
}