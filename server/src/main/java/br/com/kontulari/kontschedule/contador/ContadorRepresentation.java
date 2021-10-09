package br.com.kontulari.kontschedule.contador;

import lombok.Getter;

@Getter
public class ContadorRepresentation {
  private final Long id;
  private final String nome;
  private final String CPF;
  private final String CRC;

  public ContadorRepresentation(Contador contador) {
    this.id = contador.getId();
    this.nome = contador.getNomeCompleto();
    this.CPF = contador.getCPF();
    this.CRC = contador.getCRC();
  }
}
