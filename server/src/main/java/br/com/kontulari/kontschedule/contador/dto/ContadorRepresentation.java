package br.com.kontulari.kontschedule.contador.dto;

import br.com.kontulari.kontschedule.contador.Contador;
import br.com.kontulari.kontschedule.endereco.EnderecoRepresentation;
import lombok.Getter;

@Getter
public class ContadorRepresentation {
  private final Long id;
  private final String nome;
  private final String CPF;
  private final String CRC;
  private EnderecoRepresentation endereco;

  public ContadorRepresentation(Contador contador) {
    this.id = contador.getId();
    this.nome = contador.getNomeCompleto();
    this.CPF = contador.getCPF();
    this.CRC = contador.getCRC();
  }
}
