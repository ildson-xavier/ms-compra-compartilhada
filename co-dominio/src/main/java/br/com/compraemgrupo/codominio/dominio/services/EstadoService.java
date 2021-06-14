package br.com.compraemgrupo.codominio.dominio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.compraemgrupo.codominio.infraestrutura.entities.Estado;
import br.com.compraemgrupo.codominio.infraestrutura.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;
	
	public List<Estado> buscarEstados() {
		
		return repository.findAll();
	}
	
	public Estado buscarUf (String uf) {
		return repository.findByUf(uf)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estado não encontrado"));
	}
	
}
