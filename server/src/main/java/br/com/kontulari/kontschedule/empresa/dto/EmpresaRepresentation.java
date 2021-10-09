package br.com.kontulari.kontschedule.empresa.dto;

import br.com.kontulari.kontschedule.atividade.dto.AtividadeRepresentation;
import br.com.kontulari.kontschedule.empresa.Empresa;
import br.com.kontulari.kontschedule.endereco.dto.EnderecoRepresentation;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class EmpresaRepresentation {
  private final Long id;
  private final String razaoSocial;
  private final String nomeFantasia;
  private final String CNPJ;
  private final List<AtividadeRepresentation> atividades = new ArrayList<>();
  private final List<EnderecoRepresentation> enderecos = new ArrayList<>();

  public EmpresaRepresentation(Empresa empresa) {
    this.id = empresa.getId();
    this.razaoSocial = empresa.getRazaoSocial();
    this.nomeFantasia = empresa.getNomeFantasia();
    this.CNPJ = empresa.getCNPJ();
	/*
	 * this.atividades.addAll( empresa.getAtividades().stream()
	 * .map(AtividadeRepresentation::new) .collect(Collectors.toList()));
	 * this.enderecos.addAll( empresa.getEnderecos().stream()
	 * .map(EnderecoRepresentation::new) .collect(Collectors.toList()));
	 */
  }
}
