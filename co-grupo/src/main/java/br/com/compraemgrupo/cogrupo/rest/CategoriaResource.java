package br.com.compraemgrupo.cogrupo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compraemgrupo.cogrupo.infrastruct.entities.Categoria;
import br.com.compraemgrupo.cogrupo.infrastruct.repositories.CategoriaRepository;
import br.com.compraemgrupo.cogrupo.rest.exceptions.NotFoundCategoriaException;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaResource {

	@Autowired
	private CategoriaRepository repository;
	
	@PostMapping
	public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) {
		
		Categoria cat = repository.save(categoria);
		
		ResponseEntity.ok(cat);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping
	public List<Categoria> categorias () {
		
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Categoria categoria(@PathVariable Long id) {
		
		Categoria categoria = this.repository.findById(id)
				.orElseThrow(() -> new NotFoundCategoriaException("Categoria nao existe"));
		
		return categoria;
	}
}
