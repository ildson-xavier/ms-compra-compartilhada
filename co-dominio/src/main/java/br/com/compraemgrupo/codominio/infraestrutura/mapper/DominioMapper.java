package br.com.compraemgrupo.codominio.infraestrutura.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.compraemgrupo.codominio.dominio.model.CidadeModel;
import br.com.compraemgrupo.codominio.dominio.model.CompradorModel;
import br.com.compraemgrupo.codominio.dominio.model.EnderecoModel;
import br.com.compraemgrupo.codominio.dominio.model.EstadoModel;
import br.com.compraemgrupo.codominio.infraestrutura.entities.Cidade;
import br.com.compraemgrupo.codominio.infraestrutura.entities.Comprador;
import br.com.compraemgrupo.codominio.infraestrutura.entities.Endereco;
import br.com.compraemgrupo.codominio.infraestrutura.entities.Estado;

public class DominioMapper {

	public static Comprador mapper(CompradorModel model) {
		Comprador comprador = new Comprador();
		comprador.setCpfOuCnpj(model.getCpfOuCnpj());
		comprador.setDataCadastro(model.getDataCadastro());
		comprador.setEmail(model.getEmail());
		comprador.setNome(model.getNome());
		comprador.setSobrenome(model.getSobrenome());
		comprador.setTelefones(model.getTelefones());
		comprador.setTipoComprador(model.getTipoComprador());
		comprador.setEndereco(mapper(model.getEndereco()));
		comprador.setId(model.getId());
		return comprador;
	}
	
	public static List<Endereco> mapper(List<EnderecoModel> model) {
		List<Endereco> enderecos = new ArrayList<>();
		model.stream().forEach(m -> enderecos.add(
				new Endereco(m.getId(), 
						m.getLogradouro(), 
						m.getNumero(), 
						m.getComplemento(), 
						m.getBairro(), 
						m.getCep(), 
						null,
						mapper (m.getCidade())))); 
		return enderecos;
	}
	
	private static Cidade mapper (CidadeModel model){
		return new Cidade(model.getId(), model.getNome(), mapper (model.getEstado()));
	}
	
	private static Estado mapper (EstadoModel model) {
		return new Estado(model.getId(), model.getSigla(), model.getDescricao());
	}
	
	public static CompradorModel mapper (Comprador comprador) {
		CompradorModel model = new CompradorModel(
				comprador.getId(), 
				comprador.getNome(), 
				comprador.getSobrenome(), 
				comprador.getEmail(), 
				comprador.getTelefones(), 
				comprador.getCpfOuCnpj(), 
				comprador.getTipoComprador(), 
				mapper1 (comprador.getEndereco()),
				comprador.getDataCadastro());
		return model;
	}
	
	public static List<EnderecoModel> mapper1 (List<Endereco> enderecos) {
		List<EnderecoModel> models = new ArrayList<>();
		enderecos.stream().forEach(end -> {
			EnderecoModel model = new EnderecoModel(
					end.getId(), 
					end.getLogradouro(), 
					end.getNumero(), 
					end.getComplemento(), 
					end.getBairro(), 
					end.getCep(), 
					null, 
					mapper (end.getCidade()));
			models.add(model);
		});
		return models;
	}
	
	public static EnderecoModel mapper (Endereco end) {
			EnderecoModel model = new EnderecoModel(
					end.getId(), 
					end.getLogradouro(), 
					end.getNumero(), 
					end.getComplemento(), 
					end.getBairro(), 
					end.getCep(), 
					null, 
					mapper (end.getCidade()));

		return model;
	}
	
	public static CidadeModel mapper (Cidade cidade) {
		CidadeModel model = new CidadeModel(
				cidade.getId(), 
				cidade.getNome(), 
				mapper (cidade.getEstado()));
		return model;
	}
	
	public static EstadoModel mapper (Estado estado) {
		EstadoModel model = new EstadoModel(
				estado.getId(), 
				estado.getUf(), 
				estado.getNome());
		
		return model;
	}
}
