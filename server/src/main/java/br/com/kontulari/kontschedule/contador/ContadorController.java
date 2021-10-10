package br.com.kontulari.kontschedule.contador;

import br.com.kontulari.kontschedule.contador.dto.ContadorRegistration;
import br.com.kontulari.kontschedule.contador.dto.ContadorRepresentation;
import br.com.kontulari.kontschedule.exception.ContadorNotFoundException;
import br.com.kontulari.kontschedule.util.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/contador")
public class ContadorController {
  @Autowired private ContadorService service;

  @GetMapping("/{id}")
  public ResponseEntity<ContadorRepresentation> detalha(@PathVariable Long id)
      throws ContadorNotFoundException {
    Contador contador = service.busca(id);
    return ResponseEntity.ok(ContadorMapper.fromModel(contador));
  }

  @PutMapping("/{id}")
  public ResponseEntity<MessageResponse> updateById(
      @PathVariable Long id, @RequestBody @Valid ContadorRegistration registro)
      throws ContadorNotFoundException {
    MessageResponse message = service.updateById(id, registro);
    return ResponseEntity.ok(message);
  }
}
