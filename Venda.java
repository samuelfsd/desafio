import java.math.BigDecimal;
import java.time.LocalDate;

public class Venda{
  private LocalDate mesAno;
  private BigDecimal totalVendas;
  private Vendedor vendedor;

  public Venda(LocalDate mesAno, BigDecimal totalVendas, Vendedor vendedor){
    this.vendedor = vendedor;
    this.totalVendas = totalVendas;
    this.mesAno = mesAno;
  }

  public LocalDate getMesAno() {
      return mesAno;
  }

  public void setMesAno(LocalDate mesAno) {
      this.mesAno = mesAno;
  }

  public BigDecimal getTotalVendas() {
      return totalVendas;
  }

  public void setTotalVendas(BigDecimal totalVendas) {
      this.totalVendas = totalVendas;
  }

  public Vendedor getVendedor() {
      return vendedor;
  }

  public void setVendedor(Vendedor vendedor) {
      this.vendedor = vendedor;
  }
  
}