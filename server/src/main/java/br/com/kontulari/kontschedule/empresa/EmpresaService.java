package br.com.kontulari.kontschedule.empresa;

import br.com.kontulari.kontschedule.contador.Contador;
import br.com.kontulari.kontschedule.empresa.dto.EmpresaRegistration;
import br.com.kontulari.kontschedule.empresa.dto.EmpresaRepresentation;
import br.com.kontulari.kontschedule.exception.ContadorNotFoundException;
import br.com.kontulari.kontschedule.exception.EmpresaNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresaService {
  @Autowired private EmpresaRepository repository;

  public List<EmpresaRepresentation> busca() {
    List<Empresa> lista = (List<Empresa>) repository.findAll();
    return lista.stream().map(EmpresaRepresentation::new).collect(Collectors.toList());
  }

  public Empresa busca(Long id) {
    Optional<Empresa> optional = repository.findById(id);
    return optional.orElse(null);
  }

  @Transactional
  public Empresa cadastra(EmpresaRegistration registro) {
    Empresa empresa = registro.converte();
    // Lógica de negócio e validações extras
    repository.save(empresa);
    return empresa;
  }

  @Transactional
  public EmpresaRepresentation atualiza(Empresa empresa, EmpresaRegistration registro) {
    Empresa atualizacao = registro.converte();
    // Lógica de negócio e validações extras
    empresa.setRazaoSocial(atualizacao.getRazaoSocial());
    empresa.setNomeFantasia(atualizacao.getNomeFantasia());
    empresa.setCNPJ(atualizacao.getCNPJ());
    repository.save(empresa);
    return new EmpresaRepresentation(empresa);
  }

  @Transactional
  public void deleta(Long empresaId) throws EmpresaNotFoundException {
	  verifyIfExists(empresaId);
	  repository.deleteById(empresaId);
  }
  
  private Empresa verifyIfExists(Long id) throws EmpresaNotFoundException {
		return repository.findById(id).orElseThrow(() -> new EmpresaNotFoundException(id));
	}

}
