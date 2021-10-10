package br.com.kontulari.kontschedule.atividade.dto;

import br.com.kontulari.kontschedule.atividade.AtividadeStatus;
import br.com.kontulari.kontschedule.contador.ContadorRepository;
import br.com.kontulari.kontschedule.empresa.EmpresaRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AtividadeUpdate {
  ContadorRepository contadorRepository;
  EmpresaRepository empresaRepository;
  private Long id;
  private String nome;
  private String competencia;
  private String prazoExecucao;
  private String descricao;
  private String setor;
  private AtividadeStatus status;
  private String dataExecucao;
}
