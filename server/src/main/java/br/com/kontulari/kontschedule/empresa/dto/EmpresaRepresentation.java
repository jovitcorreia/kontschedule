package br.com.kontulari.kontschedule.empresa.dto;

import br.com.kontulari.kontschedule.atividade.dto.AtividadeRepresentation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class EmpresaRepresentation {
  private final Long id;
  private final String razaoSocial;
  private final String nomeFantasia;
  private final String cnpj;
  private final String endereco;
  private final List<AtividadeRepresentation> atividades;

  //  public EmpresaRepresentation(Empresa empresa) {
  //    this.id = empresa.getId();
  //    this.razaoSocial = empresa.getRazaoSocial();
  //    this.nomeFantasia = empresa.getNomeFantasia();
  //    this.CNPJ = empresa.getCNPJ();
  //    this.endereco = empresa.getEndereco();
  //    this.atividades.addAll(
  //        empresa.getAtividades().stream()
  //            .map(AtividadeMapper::fromModel)
  //            .collect(Collectors.toList()));
  //  }
}
