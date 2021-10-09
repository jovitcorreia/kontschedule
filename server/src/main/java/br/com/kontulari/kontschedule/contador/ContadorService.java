package br.com.kontulari.kontschedule.contador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ContadorService {
  @Autowired private ContadorRepository repository;

  @Transactional
  public Contador cadastra(ContadorRegistration registro) {
    Contador contador = registro.converte();
    // Lógica de negócio e validações extras
    repository.save(contador);
    return contador;
  }

  public Contador busca(Long id) {
    Optional<Contador> optional = repository.findById(id);
    return optional.orElse(null);
  }
}
