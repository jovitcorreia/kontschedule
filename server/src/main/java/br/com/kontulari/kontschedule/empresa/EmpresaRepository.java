package br.com.kontulari.kontschedule.empresa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
  Optional<Empresa> findByNomeFantasia(String empresaNome);
}
