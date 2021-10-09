package br.com.kontulari.kontschedule.atividade;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kontulari.kontschedule.atividade.dto.AtividadeRepresentation;
import br.com.kontulari.kontschedule.exception.AtividadeNotFoundException;

@Service
public class AtividadeService {
	@Autowired
	private AtividadeRepository repository;
	
	public AtividadeRepresentation busca(Long id) throws AtividadeNotFoundException {
		Atividade atividade = verifyIfExists(id);
		
		return new AtividadeRepresentation(atividade);
	}

	private Atividade verifyIfExists(Long id) throws AtividadeNotFoundException {
		return repository.findById(id).orElseThrow(() -> new AtividadeNotFoundException(id));
	}

	public Atividade cadastra(@Valid AtividadeRepresentation registro) {
		Atividade atividade=AtividadeMapper.fromDTO(registro);
		repository.save(atividade);
		return atividade;
	}
	
	
}
