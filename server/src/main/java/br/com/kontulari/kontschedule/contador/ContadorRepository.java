package br.com.kontulari.kontschedule.contador;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContadorRepository extends CrudRepository<Contador, Long> {}
