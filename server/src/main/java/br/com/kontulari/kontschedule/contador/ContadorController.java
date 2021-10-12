package br.com.kontulari.kontschedule.contador;

import br.com.kontulari.kontschedule.contador.dto.ContadorRegistration;
import br.com.kontulari.kontschedule.contador.dto.ContadorRepresentation;
import br.com.kontulari.kontschedule.exception.ContadorNotFoundException;
import br.com.kontulari.kontschedule.util.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/contador")
public class ContadorController {
  @Autowired
  private ContadorService service;

  @CrossOrigin(origins = "*")
  @GetMapping
  public List<ContadorRepresentation> lista() {
    return service.busca();
  }

  @CrossOrigin(origins = "*")
  @GetMapping("/{id}")
  public ResponseEntity<ContadorRepresentation> detalha(@PathVariable Long id) throws ContadorNotFoundException {
    Contador contador = service.busca(id);
    return ResponseEntity.ok(ContadorMapper.fromModel(contador));
  }

  @CrossOrigin(origins = "*")
  @PutMapping("/{id}")
  public ResponseEntity<MessageResponse> updateById(@PathVariable Long id,
      @RequestBody @Valid ContadorRegistration registro) throws ContadorNotFoundException {
    // service.atualiza(id, registro);
    MessageResponse message = service.updateById(id, registro);
    return ResponseEntity.ok(message);
  }

  @CrossOrigin(origins = "*")
  @PostMapping
  public ResponseEntity<ContadorRepresentation> cadastra(@RequestBody @Valid ContadorRegistration registro,
      UriComponentsBuilder builder) {
    Contador contador = service.cadastra(registro);
    URI uri = builder.path("/contador/{id}").buildAndExpand(contador.getId()).toUri();
    return ResponseEntity.created(uri).body(ContadorMapper.fromModel(contador));
  }
}
