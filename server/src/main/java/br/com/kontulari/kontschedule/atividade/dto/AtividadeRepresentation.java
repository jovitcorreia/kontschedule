package br.com.kontulari.kontschedule.atividade.dto;

import java.time.YearMonth;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.kontulari.kontschedule.atividade.AtividadeStatus;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class AtividadeRepresentation {
  private final Long id;
  @NotEmpty
  private final String nome;
  @NotEmpty
  private final String descricao;
  @NotEmpty
  private final String setor;
  private final YearMonth competencia;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private final Date dataExecucao;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private final Date prazoExecucao;
  private final AtividadeStatus status;  
  private final Long idEmpresa;

	/*
	 * public AtividadeRepresentation(Atividade atividade) { this.id =
	 * atividade.getId(); this.nome = atividade.getNome(); this.descricao =
	 * atividade.getDescricao(); this.competencia = atividade.getCompetencia();
	 * this.dataExecucao = atividade.getDataExecucao(); this.prazoExecucao =
	 * atividade.getPrazoExecucao(); this.status = atividade.getStatus();
	 * this.idEmpresa=atividade.getEmpresa().getId();
	 * this.setor=atividade.getSetor(); }
	 */
}
