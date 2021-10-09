package br.com.kontulari.kontschedule.contador.dto;

import br.com.kontulari.kontschedule.contador.Contador;
import br.com.kontulari.kontschedule.endereco.EnderecoRepresentation;
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
  private EnderecoRepresentation endereco;

  public Contador converte() {
    return new Contador(id, nome, sobrenome, CPF, CRC);
  }
}
