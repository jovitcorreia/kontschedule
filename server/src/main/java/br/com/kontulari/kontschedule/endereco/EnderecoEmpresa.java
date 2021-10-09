package br.com.kontulari.kontschedule.endereco;

import br.com.kontulari.kontschedule.empresa.Empresa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class EnderecoEmpresa extends Endereco {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne private Empresa empresa;
}
