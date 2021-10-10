package br.com.kontulari.kontschedule.contador;

import br.com.kontulari.kontschedule.contador.dto.ContadorRegistration;
import br.com.kontulari.kontschedule.contador.dto.ContadorRepresentation;

public class ContadorMapper {
  public static ContadorRepresentation fromModel(Contador contador) {
    return ContadorRepresentation.builder()
        .id(contador.getId())
        .nome(contador.getNome())
        .CPF(contador.getCPF())
        .CRC(contador.getCRC())
        .endereco(contador.getEndereco())
        .build();
  }

  public static Contador fromDTO(ContadorRegistration contador) {
    return Contador.builder()
        .id(contador.getId())
        .nome(contador.getNome())
        .CPF(contador.getCPF())
        .CRC(contador.getCRC())
        .endereco(contador.getEndereco())
        .build();
  }
}
