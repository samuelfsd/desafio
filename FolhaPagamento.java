import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class FolhaPagamento {

  private List<Funcionario> funcionarios;
  private List<Venda> vendas;

  public FolhaPagamento() {
    initializeData();
  }

  public List<Funcionario> getFuncionarios() {
    return funcionarios;
  }

  public List<FuncionarioComBeneficio> getFuncionariosComBeneficio(){
    return getFuncionarios().stream()
      .filter(f -> f instanceof FuncionarioComBeneficio)
      .map(f -> (FuncionarioComBeneficio) f)
      .toList();
  }

  public List<Vendedor> getVendedores(){
    return getFuncionarios().stream()
      .filter(f -> f instanceof Vendedor)
      .map(f -> (Vendedor) f)
      .toList();
  }

  public List<Venda> getVendas() {
    return vendas;
  }
  
  public void initializeData() {
    
    Vendedor anaSilva = new Vendedor("Ana Silva", LocalDate.of(2021, 12, 3));
    anaSilva.setVendas(List.of(
        new Venda(LocalDate.of(2021, 12, 1), new BigDecimal("5200"), anaSilva),
        new Venda(LocalDate.of(2022, 1, 1), new BigDecimal("4000"), anaSilva),
        new Venda(LocalDate.of(2022, 2, 1), new BigDecimal("4200"), anaSilva),
        new Venda(LocalDate.of(2022, 3, 1), new BigDecimal("5850"), anaSilva),
        new Venda(LocalDate.of(2022, 4, 1), new BigDecimal("7000"), anaSilva))
    );
    
    Vendedor joaoMendes = new Vendedor("João Mendes", LocalDate.of(2021, 12, 4));
    joaoMendes.setVendas(List.of(
        new Venda(LocalDate.of(2021, 12, 1), new BigDecimal("3400"), joaoMendes),
        new Venda(LocalDate.of(2022, 1, 1), new BigDecimal("7700"), joaoMendes),
        new Venda(LocalDate.of(2022, 2, 1), new BigDecimal("5000"), joaoMendes),
        new Venda(LocalDate.of(2022, 3, 1), new BigDecimal("5900"), joaoMendes),
        new Venda(LocalDate.of(2022, 4, 1), new BigDecimal("6500"), joaoMendes)
    ));
    
    funcionarios = List.of(
        new Secretario("Jorge Carvalho", LocalDate.of(2018, 1, 1)),
        new Secretario("Maria Souza", LocalDate.of(2015, 12, 2)),
        anaSilva, joaoMendes,
        new Gerente("Juliana Alves", LocalDate.of(2017, 7, 5)),
        new Gerente("Bento Albino", LocalDate.of(2014, 3, 6))
    );

  }

  public BigDecimal valorPagoParaFuncionariosComBeneficios(List<Funcionario> funcionarios, LocalDate mesAno) {
    return funcionarios.stream()
        .filter(f -> f.getDataContrato().isBefore(mesAno) || f.getDataContrato().equals(mesAno))
        .map(f -> f.getSalarioComBeneficio(mesAno))
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
  
  public BigDecimal valorPagoParaFuncionariosSemBenficios(List<Funcionario> funcionarios, LocalDate mesAno) {
    return funcionarios.stream()
        .filter(f -> f.getDataContrato().isBefore(mesAno) || f.getDataContrato().equals(mesAno))
        .map(f -> f.getSalario(mesAno))
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public BigDecimal totalBeneficiosPagos(List<FuncionarioComBeneficio> funcionarios, LocalDate mesAno) {
    return funcionarios.stream()
        .filter(f -> f.getDataContrato().isBefore(mesAno) || f.getDataContrato().equals(mesAno))
        .map(f -> f.getValorBeneficio(mesAno))
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public Funcionario funcionarioComMaiorSalarioNoMes(List<Funcionario> funcionarios, LocalDate mesAno) {
    Optional<Funcionario> funcMax =  funcionarios.stream()
            .filter(f -> f.getDataContrato().isBefore(mesAno) || f.getDataContrato().equals(mesAno))
            .max(Comparator.comparing(v -> v.getSalario(mesAno)));
    return funcMax.orElse(null);
  }
  
  public Funcionario valorPagoBeneficioMaisAltoNoMes(List<FuncionarioComBeneficio> funcionarios, LocalDate mesAno){
    Optional<FuncionarioComBeneficio> max = funcionarios.stream()
        .filter(f -> f.getDataContrato().isBefore(mesAno) || f.getDataContrato().equals(mesAno))
        .max(Comparator.comparing(v -> v.getValorBeneficio(mesAno)));
    return (Funcionario) max.orElse(null);
  }

  public Vendedor vendedorComMaisVendasMes(List<Vendedor> vendedores, LocalDate mesAno) {
    List<Venda> vendas = vendedores.stream()
      .map(Vendedor::getVendas)
      .reduce(new ArrayList<>(), (list1, list2) -> {
        list1.addAll(list2);
        return list1;});

    Optional<Venda> max = vendas.stream()
            .filter(v -> v.getMesAno().getMonth() == mesAno.getMonth() &&
                    v.getMesAno().getYear() == mesAno.getYear())
            .max(Comparator.comparing(Venda::getTotalVendas));
    
    return max.map(Venda::getVendedor).orElse(null);
  }
  
}