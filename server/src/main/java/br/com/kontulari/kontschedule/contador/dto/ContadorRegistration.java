package br.com.kontulari.kontschedule.contador.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ContadorRegistration {
  @NotNull @NotEmpty private String nome;
  @NotNull @NotEmpty private String sobrenome;
  @NotNull @NotEmpty private String CPF;
  @NotNull @NotEmpty private String CRC;
  private Long id;
  private String endereco;
}
