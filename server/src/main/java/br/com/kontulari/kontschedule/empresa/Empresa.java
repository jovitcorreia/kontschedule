package br.com.kontulari.kontschedule.empresa;

import br.com.kontulari.kontschedule.atividade.Atividade;
import br.com.kontulari.kontschedule.endereco.EnderecoEmpresa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class Empresa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String razaoSocial;
  private String nomeFantasia;
  private String CNPJ;

  @OneToMany(mappedBy = "empresa")
  private List<Atividade> atividades = new ArrayList<>();

  @OneToMany(mappedBy = "empresa")
  private List<EnderecoEmpresa> enderecos = new ArrayList<>();

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    Empresa empresa = (Empresa) object;
    return id.equals(empresa.id) && CNPJ.equals(empresa.CNPJ);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, CNPJ);
  }
}
