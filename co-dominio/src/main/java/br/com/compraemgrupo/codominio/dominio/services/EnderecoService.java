package br.com.compraemgrupo.codominio.dominio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.compraemgrupo.codominio.dominio.model.EnderecoModel;
import br.com.compraemgrupo.codominio.infraestrutura.entities.Endereco;
import br.com.compraemgrupo.codominio.infraestrutura.mapper.DominioMapper;
import br.com.compraemgrupo.codominio.infraestrutura.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;

	public List<EnderecoModel> buscarEnderecos() {

		List<Endereco> enderecos = repository.findAll();
		List<EnderecoModel> enderecoModels = DominioMapper.mapper1(enderecos);

		return enderecoModels;
	}

	public List<EnderecoModel> buscarEnderecoPorLogradouro(String logradouro) {
		List<Endereco> enderecos = repository.findByLogradouroContaining(logradouro);
		List<EnderecoModel> enderecoModels = DominioMapper.mapper1(enderecos);

		return enderecoModels;
	}
	
	public EnderecoModel buscarEnderecoPorId (Long id) {
		
		Endereco endereco = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado"));
		return DominioMapper.mapper(endereco);
	}
}
