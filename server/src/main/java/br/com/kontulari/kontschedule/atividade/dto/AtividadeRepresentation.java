package br.com.kontulari.kontschedule.atividade.dto;

import br.com.kontulari.kontschedule.atividade.Atividade;
import br.com.kontulari.kontschedule.atividade.AtividadeStatus;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.YearMonth;

@Getter
public class AtividadeRepresentation {
  private final Long id;
  private final String nome;
  private final String descricao;
  private final YearMonth competencia;
  private final LocalDateTime dataExecucao;
  private final LocalDateTime prazoExecucao;
  private final AtividadeStatus status;

  public AtividadeRepresentation(Atividade atividade) {
    this.id = atividade.getId();
    this.nome = atividade.getNome();
    this.descricao = atividade.getDescricao();
    this.competencia = atividade.getCompetencia();
    this.dataExecucao = atividade.getDataExecucao();
    this.prazoExecucao = atividade.getPrazoExecucao();
    this.status = atividade.getStatus();
  }
}
