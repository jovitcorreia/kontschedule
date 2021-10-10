package br.com.kontulari.kontschedule.empresa.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class EmpresaRegistration {
  @NotNull @NotEmpty private String razaoSocial;
  @NotNull @NotEmpty private String nomeFantasia;
  @NotNull @NotEmpty private String CNPJ;
}
