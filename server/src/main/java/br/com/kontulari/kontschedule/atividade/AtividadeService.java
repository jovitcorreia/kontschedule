package br.com.kontulari.kontschedule.atividade;

import br.com.kontulari.kontschedule.atividade.dto.AtividadeRegistration;
import br.com.kontulari.kontschedule.atividade.dto.AtividadeRepresentation;
import br.com.kontulari.kontschedule.atividade.dto.AtividadeUpdate;
import br.com.kontulari.kontschedule.contador.Contador;
import br.com.kontulari.kontschedule.contador.ContadorRepository;
import br.com.kontulari.kontschedule.empresa.Empresa;
import br.com.kontulari.kontschedule.empresa.EmpresaRepository;
import br.com.kontulari.kontschedule.exception.AtividadeNotFoundException;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AtividadeService {
  @Autowired private ContadorRepository contadorRepository;
  @Autowired private EmpresaRepository empresaRepository;
  @Autowired private AtividadeRepository repository;

  public List<AtividadeRepresentation> busca() {
    List<Atividade> lista = (List<Atividade>) repository.findAll();
    return lista.stream().map(AtividadeMapper::fromModel).collect(Collectors.toList());
  }

  public AtividadeRepresentation busca(Long id) throws AtividadeNotFoundException {
    Atividade atividade = verifyIfExists(id);

    return AtividadeMapper.fromModel(atividade);
  }

  private Atividade verifyIfExists(Long id) throws AtividadeNotFoundException {
    return repository.findById(id).orElseThrow(() -> new AtividadeNotFoundException(id));
  }

  @Transactional
  public AtividadeRepresentation cadastra(@Valid AtividadeRegistration registro)
      throws ParseException {
    Atividade atividade = registro.converte();
    Optional<Empresa> empresa = empresaRepository.findById(registro.getIdEmpresa());
    if (empresa.isPresent()) {
      atividade.setEmpresa(empresa.get());
      Hibernate.initialize(empresa.get().getAtividades());
      empresa.get().getAtividades().add(atividade);
    }
    Optional<Contador> contador = contadorRepository.findById(registro.getIdContador());
    if (contador.isPresent()) {
      atividade.setContador(contador.get());
      contador.get().getAtividades().add(atividade);
    }
    repository.save(atividade);
    return AtividadeMapper.fromModel(atividade);
  }

  public void deleta(Long id) throws AtividadeNotFoundException {
    verifyIfExists(id);
    repository.deleteById(id);
  }

  public List<AtividadeRepresentation> buscaPorEmpresa(Long empresaId) {
    List<Atividade> atividades = repository.findByEmpresaId(empresaId);
    return atividades.stream().map(AtividadeMapper::fromModel).collect(Collectors.toList());
  }

  public AtividadeRepresentation atualiza(Long id, AtividadeUpdate update)
      throws AtividadeNotFoundException, ParseException {
    Optional<Atividade> optional = repository.findById(id);
    if (optional.isPresent()) {
      Atividade empresa = optional.get();
      SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
      empresa.setPrazoExecucao(formato.parse(update.getPrazoExecucao()));
      empresa.setDataExecucao(formato.parse(update.getDataExecucao()));
      empresa.setDescricao(update.getDescricao());
      empresa.setNome(update.getNome());
      empresa.setStatus(update.getStatus());
      return AtividadeMapper.fromModel(empresa);
    }

    throw new AtividadeNotFoundException(update.getId());
  }
}
