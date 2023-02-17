import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Vendedor extends Funcionario implements FuncionarioComBeneficio{

  private List<Venda> vendas;

  public Vendedor(String nome, LocalDate dataContrato){
    super(nome, dataContrato);
    this.bonificacaoAnual = new BigDecimal("1800");
    this.bonificacaoPorcentagem = new BigDecimal("0.3");
    this.salarioBase = new BigDecimal("12000");
    this.vendas = new ArrayList<Venda>();
  }

  public List<Venda> getVendas(){
    return vendas;
  }

  public void setVendas(List<Venda> vendas){
    this.vendas = vendas;
  }
  
  public void addVenda(Venda venda){
    vendas.add(venda);
  }
  
  @Override
  public BigDecimal getValorBeneficio(LocalDate atDate) {
    return getSalario(atDate).multiply(this.bonificacaoPorcentagem);
  }
  
}