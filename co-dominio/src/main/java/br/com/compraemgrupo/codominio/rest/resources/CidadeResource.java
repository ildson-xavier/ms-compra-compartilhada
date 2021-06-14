package br.com.compraemgrupo.codominio.rest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compraemgrupo.codominio.dominio.model.CidadeModel;
import br.com.compraemgrupo.codominio.dominio.services.CidadeService;

@RestController
@RequestMapping("/api/v1/cidade")
public class CidadeResource {

	@Autowired
	private CidadeService service;
	
	@GetMapping
	public List<CidadeModel> buscarCidades() {
		
		return service.buscarCidades();
	}
	
	@GetMapping("/nome/{nome}")
	public List<CidadeModel> buscarCidadePorNome (@PathVariable String nome) throws Exception {
		
		return service.buscarCidadePorNome(nome);
	}
	
	@GetMapping("/id/{id}")
	public CidadeModel buscarCidadePorId (@PathVariable Long id) throws Exception {
		
		return service.buscarCidadePorId(id);
	}
	
	@GetMapping("/uf/{uf}")
	public List<CidadeModel> buscarCidadePorUf (@PathVariable String uf) throws Exception {
		
		return service.buscarCidadePorUf(uf);
	}
}
