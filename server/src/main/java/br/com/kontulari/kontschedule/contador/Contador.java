package br.com.kontulari.kontschedule.contador;

import br.com.kontulari.kontschedule.atividade.Atividade;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@Setter
@Builder
@AllArgsConstructor
public class Contador {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "contador")
  private List<Atividade> atividades = new ArrayList<>();

  private String nome;
  private String sobrenome;
  private String cpf;
  private String crc;
  private String endereco;

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    Contador contador = (Contador) object;
    return id.equals(contador.id) && cpf.equals(contador.cpf) && crc.equals(contador.crc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public String getNomeCompleto() {
    return String.format("%s %s", nome, sobrenome);
  }
}
