package br.com.compraemgrupo.codominio.dominio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.compraemgrupo.codominio.dominio.model.CidadeModel;
import br.com.compraemgrupo.codominio.infraestrutura.entities.Cidade;
import br.com.compraemgrupo.codominio.infraestrutura.mapper.DominioMapper;
import br.com.compraemgrupo.codominio.infraestrutura.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;
	
	public List<CidadeModel> buscarCidades() {
		List<CidadeModel> cidadeModels = new ArrayList<>();
		List<Cidade> cidades = repository.findAll();
		cidades.stream().forEach(cid -> {
			cidadeModels.add(DominioMapper.mapper(cid));
		});
		
		return cidadeModels;
	}
	
	public List<CidadeModel> buscarCidadePorNome(String cidade) throws Exception {
		List<CidadeModel> cidadeModels = new ArrayList<>();
		List<Cidade> cidades = repository.findByNomeLikeIgnoreCase(cidade);
		cidades.stream().forEach(cid -> {
			cidadeModels.add(DominioMapper.mapper(cid));
		});
		return cidadeModels;
	}
	
	public List<CidadeModel> buscarCidadePorUf (String uf) {
		List<CidadeModel> cidadeModels = new ArrayList<>();
		List<Cidade> cidades = repository.findByUfIgnoreCase(uf);
		cidades.stream().forEach(cid -> {
			cidadeModels.add(DominioMapper.mapper(cid));
		});
		
		return cidadeModels;
		
	}
	
	public CidadeModel buscarCidadePorId(Long id) throws Exception {
		
		Cidade cidade = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidade não encontrada"));

		return DominioMapper.mapper(cidade);
	}
}
