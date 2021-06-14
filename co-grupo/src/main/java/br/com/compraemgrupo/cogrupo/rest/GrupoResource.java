package br.com.compraemgrupo.cogrupo.rest;


import java.net.URI;
import java.net.URL;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.compraemgrupo.cogrupo.infrastruct.entities.Categoria;
import br.com.compraemgrupo.cogrupo.infrastruct.entities.Comprador;
import br.com.compraemgrupo.cogrupo.infrastruct.entities.Grupo;
import br.com.compraemgrupo.cogrupo.infrastruct.entities.ItemProposta;
import br.com.compraemgrupo.cogrupo.infrastruct.entities.Produto;
import br.com.compraemgrupo.cogrupo.infrastruct.repositories.CategoriaRepository;
import br.com.compraemgrupo.cogrupo.infrastruct.repositories.CompradorRepository;
import br.com.compraemgrupo.cogrupo.infrastruct.repositories.GrupoRepository;
import br.com.compraemgrupo.cogrupo.infrastruct.repositories.ItemPropostaRepository;
import br.com.compraemgrupo.cogrupo.infrastruct.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/v1")
public class GrupoResource {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private CompradorRepository compradorRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemPropostaRepository itemPropostaRepository;
	
	@PostMapping("/categoria/{id}/grupos")
	public ResponseEntity<Object> criarGrupo(@RequestBody Grupo grupo, @PathVariable Long id) {
		
		System.out.println(grupo + "categoria => " + id);
		
		Categoria categoria = categoriaRepository.findById(id).get();
		grupo.setCategoria(categoria);
		grupo.setDataCriacao(Calendar.getInstance().getTime());
		
		grupoRepository.save(grupo);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(grupo.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/grupos/{id}/produto")
	public ResponseEntity<Object> incluirProduto(@RequestBody Produto produto, @PathVariable Long id) {
		
		Grupo grupo = this.grupoRepository.findById(id).get();
		produto = this.produtoRepository.save(produto);
		grupo.setProduto(produto);
		grupo = this.grupoRepository.save(grupo);
		
		grupo.setProduto(produto);
		this.grupoRepository.save(grupo);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(grupo.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/grupos/{id}/comprador")
	public ResponseEntity<Object> incluirCompradores(@RequestBody Comprador comprador, @PathVariable Long id) {
		Grupo grupo = this.grupoRepository.findById(id).get();
		comprador.setGrupo(grupo);
		Comprador com = this.compradorRepository.save(comprador);
		
		grupo.adicionarComprador(com);
		this.grupoRepository.save(grupo);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(grupo.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/comprador/{id}/itemproposta")
	public ResponseEntity<Object> incluirItemProposta(@RequestBody ItemProposta itemProposta, @PathVariable Long id) {
		
		Comprador comprador = this.compradorRepository.findById(id).get();
		itemProposta.setComprador(comprador);
		ItemProposta proposta = this.itemPropostaRepository.save(itemProposta);
		comprador.getItemPropostas().add(itemProposta);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(proposta.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/grupos")
	public List<Grupo> grupos() {
		return this.grupoRepository.findAll();
	}
	
	
}
