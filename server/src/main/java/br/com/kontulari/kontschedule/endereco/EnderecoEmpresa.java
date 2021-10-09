package br.com.kontulari.kontschedule.endereco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.kontulari.kontschedule.empresa.Empresa;
import lombok.Builder;

@Entity
public class EnderecoEmpresa extends Endereco {
	@Builder
	EnderecoEmpresa(String rua, String numero, String CEP, String cidade, String estado, String pais) {
		super(rua, numero, CEP, cidade, estado, pais);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Empresa empresa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
