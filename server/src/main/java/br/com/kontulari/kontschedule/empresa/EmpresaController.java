package br.com.kontulari.kontschedule.empresa;

import br.com.kontulari.kontschedule.empresa.dto.EmpresaRegistration;
import br.com.kontulari.kontschedule.empresa.dto.EmpresaRepresentation;
import br.com.kontulari.kontschedule.exception.EmpresaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
  @Autowired private EmpresaService service;

  @GetMapping
  public List<EmpresaRepresentation> lista() {
    return service.busca();
  }

  @GetMapping("/{id}")
  public ResponseEntity<EmpresaRepresentation> detalha(@PathVariable Long id) {
    Empresa empresa = service.busca(id);
    if (empresa != null) {
      return ResponseEntity.ok(EmpresaMapper.fromModel(empresa));
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<EmpresaRepresentation> cadastra(
      @RequestBody @Valid EmpresaRegistration registro, UriComponentsBuilder builder) {
    Empresa empresa = service.cadastra(registro);
    URI uri = builder.path("/empresa/{id}").buildAndExpand(empresa.getId()).toUri();
    return ResponseEntity.created(uri).body(EmpresaMapper.fromModel(empresa));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<EmpresaRepresentation> atualiza(
      @PathVariable Long id, @RequestBody @Valid EmpresaRegistration registration) {
    Empresa empresa = service.busca(id);
    if (empresa != null) {
      return ResponseEntity.ok(service.atualiza(empresa, registration));
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable Long id) throws EmpresaNotFoundException {
    service.deleta(id);
  }
}
