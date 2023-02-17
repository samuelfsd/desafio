import java.math.BigDecimal;
import java.time.LocalDate;

public class Gerente extends Funcionario{
  
  public Gerente(String nome, LocalDate dataContrato){
    super(nome, dataContrato);
    this.bonificacaoAnual = new BigDecimal("3000");
    this.salarioBase = new BigDecimal("20000");
  }
}