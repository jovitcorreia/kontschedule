package br.com.kontulari.kontschedule.contador;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kontulari.kontschedule.contador.dto.ContadorRegistration;
import br.com.kontulari.kontschedule.contador.dto.ContadorRepresentation;
import br.com.kontulari.kontschedule.exception.ContadorNotFoundException;
import br.com.kontulari.kontschedule.util.MessageResponse;

@Service
public class ContadorService {
	@Autowired
	private ContadorRepository repository;

	@Transactional
	public Contador cadastra(ContadorRegistration registro) {
		Contador contador = registro.converte();
		// Lógica de negócio e validações extras
		repository.save(contador);
		return contador;
	}

	public MessageResponse updateById(Long id, ContadorRegistration contadorDto) throws ContadorNotFoundException {
		verifyIfExists(id);

		Contador contador = contadorDto.converte();
		repository.save(contador);
		return createMessageResponse(contador.getId(), "Updated contador with ID ");
	}

	private MessageResponse createMessageResponse(Long id, String message) {
		return MessageResponse.builder().message(message + id).build();
	}

	public ContadorRepresentation busca(Long id) throws ContadorNotFoundException {
		Contador contador = verifyIfExists(id);
		contador.getEndereco();
		ContadorRepresentation contadorRep = new ContadorRepresentation(contador);
		return contadorRep;
	}

	private Contador verifyIfExists(Long id) throws ContadorNotFoundException {
		return repository.findById(id).orElseThrow(() -> new ContadorNotFoundException(id));
	}
}
