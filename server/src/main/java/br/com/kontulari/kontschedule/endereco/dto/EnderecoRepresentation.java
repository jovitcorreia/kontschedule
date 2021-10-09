package br.com.kontulari.kontschedule.endereco.dto;

import br.com.kontulari.kontschedule.endereco.Endereco;

public class EnderecoRepresentation {
  private final String endereco;

  public EnderecoRepresentation(Endereco endereco) {
    this.endereco = endereco.toString();
  }
}
