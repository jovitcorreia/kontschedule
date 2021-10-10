package br.com.kontulari.kontschedule.atividade.dto;

import br.com.kontulari.kontschedule.atividade.Atividade;
import br.com.kontulari.kontschedule.atividade.AtividadeStatus;
import br.com.kontulari.kontschedule.contador.ContadorRepository;
import br.com.kontulari.kontschedule.empresa.EmpresaRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@AllArgsConstructor
@Getter
public class AtividadeRegistration {
  ContadorRepository contadorRepository;
  EmpresaRepository empresaRepository;
  @NotNull @NotEmpty private String nome;
  @NotNull @NotEmpty private String competencia;
  @NotNull @NotEmpty private String prazoExecucao;
  @NotNull private Long idEmpresa;
  @NotNull private Long idContador;
  private String descricao;
  private String setor;

  public Atividade converte() throws ParseException {
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    return Atividade.builder()
        .nome(nome)
        .competencia(formato.parse(competencia))
        .prazoExecucao(formato.parse(prazoExecucao))
        .descricao(descricao)
        .setor(setor)
        .status(AtividadeStatus.PENDENTE)
        .dataExecucao(null)
        .build();
  }
}
