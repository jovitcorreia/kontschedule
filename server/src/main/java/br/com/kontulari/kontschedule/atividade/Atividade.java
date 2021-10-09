package br.com.kontulari.kontschedule.atividade;

import java.time.YearMonth;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.kontulari.kontschedule.empresa.Empresa;
import br.com.kontulari.kontschedule.util.CompetenciaConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Atividade {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne private Empresa empresa;

  private String nome;
  private String descricao;
  private String setor;

  @Convert(converter = CompetenciaConverter.class)
  private YearMonth competencia;

  private AtividadeStatus status = AtividadeStatus.PENDENTE;

  private Date dataExecucao;
  private Date prazoExecucao;

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
