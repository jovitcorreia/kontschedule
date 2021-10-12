package br.com.kontulari.kontschedule.contador.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ContadorUpdate {
  private Long id;
  private String nome;
  private String sobrenome;
  private String endereco;
  private String cpf;
  private String crc;
}
