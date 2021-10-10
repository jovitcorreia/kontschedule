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

  private String nome;
  private String sobrenome;
  private String CPF;
  private String CRC;
  private String endereco;

  @OneToMany(mappedBy = "contador")
  private List<Atividade> atividades = new ArrayList<>();

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    Contador contador = (Contador) object;
    return id.equals(contador.id) && CPF.equals(contador.CPF) && CRC.equals(contador.CRC);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public String getNomeCompleto() {
    return String.format("%s %s", nome, sobrenome);
  }
}
