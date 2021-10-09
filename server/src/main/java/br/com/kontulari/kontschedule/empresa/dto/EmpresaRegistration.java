package br.com.kontulari.kontschedule.empresa.dto;

import br.com.kontulari.kontschedule.empresa.Empresa;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EmpresaRegistration {
  @NotNull @NotEmpty private String razaoSocial;
  @NotNull @NotEmpty private String nomeFantasia;
  @NotNull @NotEmpty private String CNPJ;

  public Empresa converte() {
    return new Empresa(razaoSocial, nomeFantasia, CNPJ);
  }
}
