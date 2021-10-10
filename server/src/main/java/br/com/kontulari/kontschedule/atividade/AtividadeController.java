package br.com.kontulari.kontschedule.atividade;

import br.com.kontulari.kontschedule.atividade.dto.AtividadeRegistration;
import br.com.kontulari.kontschedule.atividade.dto.AtividadeRepresentation;
import br.com.kontulari.kontschedule.atividade.dto.AtividadeUpdate;
import br.com.kontulari.kontschedule.exception.AtividadeNotFoundException;
import br.com.kontulari.kontschedule.exception.ContadorNotFoundException;
import br.com.kontulari.kontschedule.exception.EmpresaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {
  @Autowired private AtividadeService service;

  @GetMapping
  public List<AtividadeRepresentation> lista() {
    return service.busca();
  }

  @GetMapping("/{id}")
  public ResponseEntity<AtividadeRepresentation> detalha(@PathVariable Long id)
      throws AtividadeNotFoundException {
    AtividadeRepresentation atividade = service.busca(id);
    return ResponseEntity.ok(atividade);
  }

  @PutMapping("/{id}")
  public ResponseEntity<AtividadeRepresentation> atualiza(
      @PathVariable Long id, @RequestBody @Valid AtividadeUpdate registro)
      throws AtividadeNotFoundException, ParseException {
    AtividadeRepresentation atividade = service.atualiza(registro);
    return ResponseEntity.ok(atividade);
  }

  @GetMapping("/empresa/{id}")
  public ResponseEntity<List<AtividadeRepresentation>> listaPorEmpresa(@PathVariable Long id) {
    List<AtividadeRepresentation> atividade = service.buscaPorEmpresa(id);
    return ResponseEntity.ok(atividade);
  }

  @PostMapping
  public ResponseEntity<AtividadeRepresentation> cadastra(
      @RequestBody @Valid AtividadeRegistration registro, UriComponentsBuilder builder)
      throws ContadorNotFoundException, EmpresaNotFoundException, ParseException {
    AtividadeRepresentation atividade = service.cadastra(registro);
    URI uri = builder.path("/atividade/{id}").buildAndExpand(atividade.getId()).toUri();
    return ResponseEntity.created(uri).body(atividade);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleta(@PathVariable Long id) throws AtividadeNotFoundException {
    service.deleta(id);
  }
}
