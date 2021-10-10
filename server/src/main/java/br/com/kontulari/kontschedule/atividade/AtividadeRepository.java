package br.com.kontulari.kontschedule.atividade;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtividadeRepository extends CrudRepository<Atividade, Long> {
  @Query("SELECT a FROM Atividade a WHERE a.empresa.id = :empresaId")
  List<Atividade> findByEmpresaId(@Param("empresaId") Long empresaId);
}
