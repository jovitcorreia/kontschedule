package br.com.kontulari.kontschedule.contador.dto;

import br.com.kontulari.kontschedule.atividade.dto.AtividadeRepresentation;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ContadorRepresentation {
  private final Long id;
  private final String nome;
  private final String cpf;
  private final String crc;
  private final String endereco;
  private final List<AtividadeRepresentation> atividades;
}
