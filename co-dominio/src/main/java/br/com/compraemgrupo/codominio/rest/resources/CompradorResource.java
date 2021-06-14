package br.com.compraemgrupo.codominio.rest.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compraemgrupo.codominio.dominio.dto.CompradorDto;
import br.com.compraemgrupo.codominio.dominio.model.CompradorModel;
import br.com.compraemgrupo.codominio.dominio.services.CompradorService;

@RestController
@RequestMapping("/api/v1/comprador")
public class CompradorResource {

	@Autowired
	private CompradorService service;
	
	@PostMapping
	public ResponseEntity<Void> adicionarComprador (@RequestBody @Valid CompradorDto compradorDto) {
		
		System.out.println(compradorDto);
		System.out.println("----------------------");
		service.adicionarComprador(compradorDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping
	public List<CompradorModel> buscarCompradores () {
		
		List<CompradorModel> compradores = this.service.buscaComprador();
		
		return compradores;
	}
	
	@GetMapping("/{id}")
	public CompradorModel buscarPorId (@PathVariable Long id) {
		
		CompradorModel comprador = this.service.buscarPorId(id);
		
		return comprador;
	}
	
	@PutMapping(value = "{id}", consumes = "application/json;charset=UTF-8")
	public ResponseEntity<Void> atualizarComprador (@RequestBody CompradorModel comprador, @PathVariable Long id) {
		comprador.setId(id);
		this.service.atualizar(comprador);
		return ResponseEntity.noContent().build();
	}
}
