package br.com.kontulari.kontschedule.empresa.dto;

import br.com.kontulari.kontschedule.atividade.dto.AtividadeRepresentation;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class EmpresaRegistration {
  private final List<AtividadeRepresentation> atividades = new ArrayList<>();
  @NotNull @NotEmpty private String razaoSocial;
  @NotNull @NotEmpty private String nomeFantasia;
  @NotNull @NotEmpty private String cnpj;
  private String endereco;
}
