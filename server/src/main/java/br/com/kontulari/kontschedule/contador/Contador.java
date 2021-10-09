package br.com.kontulari.kontschedule.contador;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.kontulari.kontschedule.endereco.EnderecoContador;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class Contador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String sobrenome;

	private String CPF;
	private String CRC;
	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private EnderecoContador endereco;

	public Contador(Long id, String nome, String sobrenome, String CPF, String CRC) {
		this.id=id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.CPF = CPF;
		this.CRC = CRC;
	}
	
	public Contador(Long id) {
		this.id=id;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null || getClass() != object.getClass())
			return false;
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
