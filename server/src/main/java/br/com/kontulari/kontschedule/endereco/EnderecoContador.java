package br.com.kontulari.kontschedule.endereco;

import br.com.kontulari.kontschedule.contador.Contador;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class EnderecoContador extends Endereco {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne private Contador contador;
}
