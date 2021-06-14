package br.com.compraemgrupo.codominio.dominio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.compraemgrupo.codominio.dominio.builder.DominioBuilder;
import br.com.compraemgrupo.codominio.dominio.dto.CompradorDto;
import br.com.compraemgrupo.codominio.dominio.model.CompradorModel;
import br.com.compraemgrupo.codominio.dominio.model.EnderecoModel;
import br.com.compraemgrupo.codominio.infraestrutura.entities.Cidade;
import br.com.compraemgrupo.codominio.infraestrutura.entities.Comprador;
import br.com.compraemgrupo.codominio.infraestrutura.entities.Endereco;
import br.com.compraemgrupo.codominio.infraestrutura.mapper.DominioMapper;
import br.com.compraemgrupo.codominio.infraestrutura.repositories.CidadeRepository;
import br.com.compraemgrupo.codominio.infraestrutura.repositories.CompradorRepository;
import br.com.compraemgrupo.codominio.infraestrutura.repositories.EnderecoRepository;

@Service
public class CompradorService {

	@Autowired
	private CompradorRepository compradorRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	public CompradorModel adicionarComprador(CompradorDto dto) {

		CompradorModel comprador = DominioBuilder.builder().adicionarEstado(dto).adicionarCidade(dto)
				.adicionarEndereco(dto).adicionarTelefone(dto).adicionarComprador(dto).get();

		System.out.println(comprador);

		List<EnderecoModel> enderecosModel = comprador.getEndereco();

		Comprador compradorId = this.compradorRepository.save(DominioMapper.mapper(comprador));

		List<Endereco> enderecos = DominioMapper.mapper(enderecosModel);

		enderecos.stream().forEach(end -> {
			Cidade cid = end.getCidade();
			cid = this.cidadeRepository.findById(cid.getId()).orElse(null);
			end.setComprador(compradorId);
		});

		this.enderecoRepository.saveAll(enderecos);

		return comprador;
	}

	public List<CompradorModel> buscaComprador() {
		List<CompradorModel> compradores = new ArrayList<>();

		List<Comprador> comprador = this.compradorRepository.findAll();

		comprador.stream().forEach(com -> {
			compradores.add(DominioMapper.mapper(com));
		});
		return compradores;
	}

	public CompradorModel buscarPorId(Long id) {
		Comprador comprador = this.compradorRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comprador não encontrado"));

		return DominioMapper.mapper(comprador);
	}

	public CompradorModel atualizar(CompradorModel model) {

		Comprador comprador = DominioMapper.mapper(model);

		this.compradorRepository.save(comprador);

		List<Endereco> enderecos = DominioMapper.mapper(model.getEndereco());
		enderecos.stream().forEach(end -> {
			end.setComprador(comprador);
		});

		this.enderecoRepository.saveAll(enderecos);

		return model;
	}
}
