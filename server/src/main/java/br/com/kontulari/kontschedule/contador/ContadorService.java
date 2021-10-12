package br.com.kontulari.kontschedule.contador;

import br.com.kontulari.kontschedule.contador.dto.ContadorRegistration;
import br.com.kontulari.kontschedule.contador.dto.ContadorRepresentation;
import br.com.kontulari.kontschedule.contador.dto.ContadorUpdate;
import br.com.kontulari.kontschedule.exception.ContadorNotFoundException;
import br.com.kontulari.kontschedule.util.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContadorService {
  @Autowired private ContadorRepository repository;

  public MessageResponse updateById(Long id, ContadorRegistration contadorDto)
      throws ContadorNotFoundException {
    verifyIfExists(id);
    Contador contador = ContadorMapper.fromDTO(contadorDto);
    repository.save(contador);
    return createMessageResponse(contador.getId(), "Updated contador with ID ");
  }

  private MessageResponse createMessageResponse(Long id, String message) {
    return MessageResponse.builder().message(message + id).build();
  }

  public List<ContadorRepresentation> busca() {
    List<Contador> lista = (List<Contador>) repository.findAll();
    return lista.stream().map(ContadorMapper::fromModel).collect(Collectors.toList());
  }

  public Contador busca(Long id) throws ContadorNotFoundException {
    return verifyIfExists(id);
  }

  private Contador verifyIfExists(Long id) throws ContadorNotFoundException {
    return repository.findById(id).orElseThrow(() -> new ContadorNotFoundException(id));
  }

  @Transactional
  public Contador cadastra(ContadorRegistration registro) {
    Contador contador = ContadorMapper.fromDTO(registro);
    repository.save(contador);
    return contador;
  }

  @Transactional
  public ContadorRepresentation atualiza(Long id, ContadorUpdate update)
      throws ContadorNotFoundException {
    Optional<Contador> optional = repository.findById(id);
    if (optional.isPresent()) {
      Contador contador = optional.get();
      contador.setNome(update.getNome());
      contador.setSobrenome(update.getSobrenome());
      contador.setEndereco(update.getEndereco());
      contador.setCpf(update.getCpf());
      contador.setCrc(update.getCrc());
      return ContadorMapper.fromModel(contador);
    }
    throw new ContadorNotFoundException(update.getId());
  }
}
