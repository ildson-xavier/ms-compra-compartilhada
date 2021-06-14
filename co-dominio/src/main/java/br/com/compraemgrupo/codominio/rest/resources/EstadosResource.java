package br.com.compraemgrupo.codominio.rest.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compraemgrupo.codominio.dominio.model.EstadoModel;
import br.com.compraemgrupo.codominio.dominio.services.EstadoService;
import br.com.compraemgrupo.codominio.infraestrutura.entities.Estado;
import br.com.compraemgrupo.codominio.infraestrutura.mapper.DominioMapper;

@RestController
@RequestMapping("/api/v1/uf")
public class EstadosResource {

	@Autowired
	private EstadoService service;
	
	@GetMapping
	public List<EstadoModel> buscarEstados() {
		List<EstadoModel> estadoModels = new ArrayList<>();
		List<Estado> estados = service.buscarEstados();
		
		estados.stream().forEach(est -> {
			estadoModels.add(DominioMapper.mapper(est));
		});
		
		return estadoModels;
	}
	
	@GetMapping("/{uf}")
	public EstadoModel buscarPorUf(@PathVariable String uf) {
		Estado estado = service.buscarUf(uf);
		EstadoModel model = DominioMapper.mapper(estado);
		return model;
	}
}
