package br.com.kontulari.kontschedule.endereco;

import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
public class Endereco {
  private String rua;
  private String numero;
  private String CEP;
  private String cidade;
  private String estado;
  private String pais;

  @Override
  public String toString() {
    return String.format("%s, n.º %s. CEP: %s. %s, %s, %s", rua, numero, CEP, cidade, estado, pais);
  }
}
