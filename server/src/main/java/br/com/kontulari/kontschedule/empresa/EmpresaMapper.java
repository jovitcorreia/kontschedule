package br.com.kontulari.kontschedule.empresa;

import br.com.kontulari.kontschedule.atividade.AtividadeMapper;
import br.com.kontulari.kontschedule.atividade.dto.AtividadeRepresentation;
import br.com.kontulari.kontschedule.empresa.dto.EmpresaRegistration;
import br.com.kontulari.kontschedule.empresa.dto.EmpresaRepresentation;
import br.com.kontulari.kontschedule.exception.ContadorNotFoundException;

import java.util.stream.Collectors;

public class EmpresaMapper {
  public static EmpresaRepresentation fromModel(Empresa empresa) {
    return EmpresaRepresentation.builder()
        .id(empresa.getId())
        .CNPJ(empresa.getCNPJ())
        .razaoSocial(empresa.getRazaoSocial())
        .nomeFantasia(empresa.getNomeFantasia())
        .endereco(empresa.getEndereco())
        .build();
  }

  public static Empresa fromDTO(EmpresaRepresentation representation) {
    Empresa empresa =
        Empresa.builder()
            .id(representation.getId())
            .CNPJ(representation.getCNPJ())
            .razaoSocial(representation.getRazaoSocial())
            .nomeFantasia(representation.getNomeFantasia())
            .endereco(representation.getEndereco())
            .build();
    empresa.setAtividades(
        representation.getAtividades().stream()
            .map(
                (AtividadeRepresentation atividade) -> {
                  try {
                    return AtividadeMapper.fromDTO(atividade);
                  } catch (ContadorNotFoundException e) {
                    e.printStackTrace();
                  }
                  return null;
                })
            .collect(Collectors.toList()));
    return empresa;
  }

  public static Empresa fromModel(EmpresaRegistration empresa) {
    return Empresa.builder()
        .CNPJ(empresa.getCNPJ())
        .razaoSocial(empresa.getRazaoSocial())
        .nomeFantasia(empresa.getNomeFantasia())
        .build();
  }
}
