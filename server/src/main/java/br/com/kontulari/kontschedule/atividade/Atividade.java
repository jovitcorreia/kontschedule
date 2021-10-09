package br.com.kontulari.kontschedule.atividade;

import br.com.kontulari.kontschedule.empresa.Empresa;
import br.com.kontulari.kontschedule.util.CompetenciaConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class Atividade {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne private Empresa empresa;

  private String nome;
  private String descricao;

  @Convert(converter = CompetenciaConverter.class)
  private YearMonth competencia;

  private AtividadeStatus status = AtividadeStatus.PENDENTE;

  private LocalDateTime dataExecucao;
  private LocalDateTime prazoExecucao;

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    Atividade atividade = (Atividade) object;
    return id.equals(atividade.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
