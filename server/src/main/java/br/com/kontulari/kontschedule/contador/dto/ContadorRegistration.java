package br.com.kontulari.kontschedule.contador.dto;

import br.com.kontulari.kontschedule.atividade.dto.AtividadeRepresentation;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class ContadorRegistration {
  private final List<AtividadeRepresentation> atividades = new ArrayList<>();
  private String nome;
  private String sobrenome;
  private String cpf;
  private String crc;
  private String endereco;
}
