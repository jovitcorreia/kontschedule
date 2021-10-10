package br.com.kontulari.kontschedule.contador.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ContadorRepresentation {
  private final Long id;
  private final String nome;
  private final String CPF;
  private final String CRC;
  private final String endereco;
}
