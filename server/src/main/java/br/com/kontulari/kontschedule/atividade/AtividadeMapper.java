package br.com.kontulari.kontschedule.atividade;

import br.com.kontulari.kontschedule.atividade.dto.AtividadeRepresentation;
import br.com.kontulari.kontschedule.empresa.Empresa;

public class AtividadeMapper {
	
	public static Atividade fromDTO(AtividadeRepresentation atividadeDto) {
		return Atividade.builder()
				.id(atividadeDto.getId())
				.competencia(atividadeDto.getCompetencia())
				.dataExecucao(atividadeDto.getDataExecucao())
				.descricao(atividadeDto.getDescricao())
				.nome(atividadeDto.getNome())
				.prazoExecucao(atividadeDto.getPrazoExecucao())
				.status(atividadeDto.getStatus())
				.empresa(new Empresa(atividadeDto.getIdEmpresa()))
				.build();
	}

}
