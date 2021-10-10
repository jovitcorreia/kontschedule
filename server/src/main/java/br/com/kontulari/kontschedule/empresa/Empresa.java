package br.com.kontulari.kontschedule.empresa;

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
public class Empresa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String razaoSocial;
  private String nomeFantasia;
  private String cnpj;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "empresa")
  private List<Atividade> atividades = new ArrayList<>();

  private String endereco;

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    Empresa empresa = (Empresa) object;
    return id.equals(empresa.id) && cnpj.equals(empresa.cnpj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cnpj);
  }
}
