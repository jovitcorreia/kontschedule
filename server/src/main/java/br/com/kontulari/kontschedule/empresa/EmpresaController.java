package br.com.kontulari.kontschedule.empresa;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.kontulari.kontschedule.empresa.dto.EmpresaRegistration;
import br.com.kontulari.kontschedule.empresa.dto.EmpresaRepresentation;
import br.com.kontulari.kontschedule.exception.EmpresaNotFoundException;

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
      return ResponseEntity.ok(new EmpresaRepresentation(empresa));
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<EmpresaRepresentation> cadastra(
      @RequestBody @Valid EmpresaRegistration registro, UriComponentsBuilder builder) {
    Empresa empresa = service.cadastra(registro);
    URI uri = builder.path("/empresa/{id}").buildAndExpand(empresa.getId()).toUri();
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
  
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable Long id) throws EmpresaNotFoundException {
      service.deleta(id);
  } 
}
