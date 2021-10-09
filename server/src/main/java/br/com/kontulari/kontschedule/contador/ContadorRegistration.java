package br.com.kontulari.kontschedule.contador;

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

  public Contador converte() {
    return new Contador(nome, sobrenome, CPF, CRC);
  }
}
