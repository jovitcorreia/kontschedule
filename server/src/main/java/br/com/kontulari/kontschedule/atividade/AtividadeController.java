package br.com.kontulari.kontschedule.atividade;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.kontulari.kontschedule.atividade.dto.AtividadeRepresentation;
import br.com.kontulari.kontschedule.exception.AtividadeNotFoundException;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {
	@Autowired
	private AtividadeService service;

	@GetMapping("/{id}")
	public ResponseEntity<AtividadeRepresentation> detalha(@PathVariable Long id) throws AtividadeNotFoundException {
		AtividadeRepresentation atividade = service.busca(id);
		return ResponseEntity.ok(atividade);
	}
	
	@GetMapping("/empresa/{id}")
	public ResponseEntity<List<AtividadeRepresentation>> listaPorEmpresa(@PathVariable Long id) throws AtividadeNotFoundException {
		List<AtividadeRepresentation> atividade = service.buscaPorEmpresa(id);
		return ResponseEntity.ok(atividade);
	}

	@PostMapping
	public ResponseEntity<AtividadeRepresentation> cadastra(@RequestBody @Valid AtividadeRepresentation registro,
			UriComponentsBuilder builder) {
		AtividadeRepresentation atividade = service.cadastra(registro);
		URI uri = builder.path("/atividade/{id}").buildAndExpand(atividade.getId()).toUri();
		return ResponseEntity.created(uri).body(atividade);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleta(@PathVariable Long id) throws AtividadeNotFoundException{
		service.deleta(id);	
	}
	
	

}
