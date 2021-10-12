package br.com.kontulari.kontschedule.contador;

import br.com.kontulari.kontschedule.atividade.AtividadeMapper;
import br.com.kontulari.kontschedule.contador.dto.ContadorRegistration;
import br.com.kontulari.kontschedule.contador.dto.ContadorRepresentation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class ContadorMapper {
  public static ContadorRepresentation fromModel(Contador contador) {
    return ContadorRepresentation.builder()
        .id(contador.getId())
        .nome(contador.getNome())
        .cpf(contador.getCpf())
        .crc(contador.getCrc())
        .endereco(contador.getEndereco())
        .atividades(
            contador.getAtividades().stream()
                .map(AtividadeMapper::fromModel)
                .collect(Collectors.toList()))
        .build();
  }

  public static Contador fromDTO(ContadorRegistration contador) {
    return Contador.builder()
        .nome(contador.getNome())
        .cpf(contador.getCpf())
        .crc(contador.getCrc())
        .endereco(contador.getEndereco())
        .atividades(new ArrayList<>())
        .build();
  }
}
