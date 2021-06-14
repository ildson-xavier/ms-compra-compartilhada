package br.com.compraemgrupo.codominio.rest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compraemgrupo.codominio.dominio.model.EnderecoModel;
import br.com.compraemgrupo.codominio.dominio.services.EnderecoService;

@RestController
@RequestMapping("/api/v1/endereco")
public class EnderecoResource {

	@Autowired
	private EnderecoService service;
	
	@GetMapping
	public List<EnderecoModel> buscarEnderecos() {
		List<EnderecoModel> enderecos = service.buscarEnderecos();
		return enderecos;
	}
	
	@GetMapping("/logradouro/{logradouro}")
	public List<EnderecoModel> buscarPorLogradouro(@PathVariable String logradouro) {
		List<EnderecoModel> enderecos = service.buscarEnderecoPorLogradouro(logradouro);
		return enderecos;
	}
	
	@GetMapping("/id/{id}")
	public EnderecoModel buscarPorId(@PathVariable Long id) {
		EnderecoModel endereco = service.buscarEnderecoPorId(id);
		return endereco;
	}
}
