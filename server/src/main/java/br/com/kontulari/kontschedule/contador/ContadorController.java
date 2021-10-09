package br.com.kontulari.kontschedule.contador;

import br.com.kontulari.kontschedule.contador.dto.ContadorRegistration;
import br.com.kontulari.kontschedule.contador.dto.ContadorRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/contador")
public class ContadorController {
  @Autowired private ContadorService service;

  @GetMapping("/{id}")
  public ResponseEntity<ContadorRepresentation> detalha(@PathVariable Long id) {
    Contador contador = service.busca(id);
    if (contador != null) {
      return ResponseEntity.ok(new ContadorRepresentation(contador));
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<ContadorRepresentation> cadastra(
      @RequestBody @Valid ContadorRegistration registro, UriComponentsBuilder builder) {
    Contador contador = service.cadastra(registro);
    URI uri = builder.path("/contador/{id}").buildAndExpand(contador.getId()).toUri();
    return ResponseEntity.created(uri).body(new ContadorRepresentation(contador));
  }
}
