package br.com.kontulari.kontschedule.atividade;

import br.com.kontulari.kontschedule.contador.Contador;
import br.com.kontulari.kontschedule.empresa.Empresa;
import br.com.kontulari.kontschedule.util.CompetenciaConverter;
import lombok.*;

import javax.persistence.*;
import java.time.YearMonth;
import java.util.Date;
import java.util.Objects;

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
  @ManyToOne private Contador contador;

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
