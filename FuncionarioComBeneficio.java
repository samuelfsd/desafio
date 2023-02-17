import java.math.BigDecimal;
import java.time.LocalDate;
public interface FuncionarioComBeneficio{
  BigDecimal getValorBeneficio(LocalDate atDate);
  LocalDate getDataContrato();
}