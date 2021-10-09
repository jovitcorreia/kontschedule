package br.com.kontulari.kontschedule.endereco;

import br.com.kontulari.kontschedule.contador.Contador;
import br.com.kontulari.kontschedule.empresa.Empresa;

public class EnderecoMapper {
	
	public static EnderecoRepresentation fromModel(Endereco endereco) {
		EnderecoRepresentation enderecoRep=EnderecoRepresentation.builder()
				.CEP(endereco.getCEP())
				.cidade(endereco.getCidade())
				.estado(endereco.getEstado())
				.numero(endereco.getNumero())
				.pais(endereco.getPais())
				.rua(endereco.getRua())
				.build();
		if(endereco instanceof EnderecoContador) {
			EnderecoContador enderecoContador=(EnderecoContador)endereco;
			enderecoRep.setId(enderecoContador.getId());
			enderecoRep.setIdContador(enderecoContador.getContador().getId());
		}
		if(endereco instanceof EnderecoEmpresa) {
			EnderecoEmpresa enderecoEmpresa=(EnderecoEmpresa)endereco;
			enderecoRep.setId(enderecoEmpresa.getId());
			enderecoRep.setIdEmpresa(enderecoEmpresa.getEmpresa().getId());
		}
		return enderecoRep;
	}
	
	public static EnderecoContador toEnderecoContador(EnderecoRepresentation endereco) {
		EnderecoContador enderecoContador=EnderecoContador.builder()
				.CEP(endereco.getCEP())
				.cidade(endereco.getCidade())
				.estado(endereco.getEstado())
				.numero(endereco.getNumero())
				.pais(endereco.getPais())
				.rua(endereco.getRua())
				.build();
		Contador contador =new Contador(endereco.getIdContador());
		enderecoContador.setId(endereco.getId());
		enderecoContador.setContador(contador);
		return enderecoContador;
	}
	
	public static EnderecoEmpresa toEnderecoEmpresa(EnderecoRepresentation endereco) {
		EnderecoEmpresa enderecoEmpresa=EnderecoEmpresa.builder()
				.CEP(endereco.getCEP())
				.cidade(endereco.getCidade())
				.estado(endereco.getEstado())
				.numero(endereco.getNumero())
				.pais(endereco.getPais())
				.rua(endereco.getRua())
				.build();
		Empresa empresa =new Empresa(endereco.getIdEmpresa());
		enderecoEmpresa.setId(endereco.getId());
		enderecoEmpresa.setEmpresa(empresa);
		return enderecoEmpresa;
	}

}
