package br.com.kontulari.kontschedule.endereco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.kontulari.kontschedule.contador.Contador;
import lombok.Builder;

@Entity
public class EnderecoContador extends Endereco {

	@Builder
	public EnderecoContador(String rua, String numero, String CEP, String cidade, String estado, String pais) {
		super(rua, numero, CEP, cidade, estado, pais);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Contador contador;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contador getContador() {
		return contador;
	}

	public void setContador(Contador contador) {
		this.contador = contador;
	}
}
