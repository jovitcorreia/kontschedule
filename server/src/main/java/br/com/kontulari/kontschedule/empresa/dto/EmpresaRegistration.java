package br.com.kontulari.kontschedule.empresa.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.kontulari.kontschedule.empresa.Empresa;
import lombok.Data;

@Data
public class EmpresaRegistration {
  @NotNull @NotEmpty private String razaoSocial;
  @NotNull @NotEmpty private String nomeFantasia;
  @NotNull @NotEmpty private String CNPJ;

  public Empresa converte() {
    return new Empresa(razaoSocial, nomeFantasia, CNPJ);
  }
}
