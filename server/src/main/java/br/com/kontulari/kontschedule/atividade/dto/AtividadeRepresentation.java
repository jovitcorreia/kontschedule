package br.com.kontulari.kontschedule.atividade.dto;

import br.com.kontulari.kontschedule.atividade.AtividadeStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.YearMonth;
import java.util.Date;

@Data
@Builder
public class AtividadeRepresentation {
  private final Long id;
  @NotEmpty private final String nome;
  @NotEmpty private final String descricao;
  @NotEmpty private final String setor;

  private final Long idEmpresa;
  private final Long idContador;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd")
  private final YearMonth competencia;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private final Date dataExecucao;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private final Date prazoExecucao;

  private final AtividadeStatus status;
}
