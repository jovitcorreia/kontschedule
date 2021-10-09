package br.com.kontulari.kontschedule.contador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.kontulari.kontschedule.contador.dto.ContadorRegistration;
import br.com.kontulari.kontschedule.contador.dto.ContadorRepresentation;
import br.com.kontulari.kontschedule.exception.ContadorNotFoundException;
import br.com.kontulari.kontschedule.util.MessageResponse;

@RestController
@RequestMapping("/contador")
public class ContadorController {
	@Autowired
	private ContadorService service;

	@GetMapping("/{id}")
	public ResponseEntity<ContadorRepresentation> detalha(@PathVariable Long id) throws ContadorNotFoundException {
		ContadorRepresentation contador = service.busca(id);
		
		return ResponseEntity.ok(contador);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MessageResponse> updateById(@PathVariable Long id, @RequestBody @Valid ContadorRegistration registro,
			UriComponentsBuilder builder) throws ContadorNotFoundException {
		MessageResponse message = service.updateById(id, registro);
		
		return ResponseEntity.ok(message);
	}
}
