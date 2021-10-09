package br.com.kontulari.kontschedule.empresa;

import br.com.kontulari.kontschedule.empresa.dto.EmpresaRegistration;
import br.com.kontulari.kontschedule.empresa.dto.EmpresaRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("./empresa")
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
      return ResponseEntity.ok(new EmpresaRepresentation(empresa));
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<EmpresaRepresentation> cadastra(
      @RequestBody @Valid EmpresaRegistration registro, UriComponentsBuilder builder) {
    Empresa empresa = service.cadastra(registro);
    URI uri = builder.path("/contador/{id}").buildAndExpand(empresa.getId()).toUri();
    return ResponseEntity.created(uri).body(new EmpresaRepresentation(empresa));
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
}
