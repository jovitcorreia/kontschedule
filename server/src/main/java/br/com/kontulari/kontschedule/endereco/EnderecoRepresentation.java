package br.com.kontulari.kontschedule.endereco;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoRepresentation {
	private String rua;
	private String numero;
	private String CEP;
	private String cidade;
	private String estado;
	private String pais;
	private Long id;
	private Long idContador;
	private Long idEmpresa;
}
