package br.com.compraemgrupo.codominio.dominio.builder;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import br.com.compraemgrupo.codominio.dominio.dto.CompradorDto;
import br.com.compraemgrupo.codominio.dominio.enumeracao.TipoComprador;
import br.com.compraemgrupo.codominio.dominio.model.CidadeModel;
import br.com.compraemgrupo.codominio.dominio.model.CompradorModel;
import br.com.compraemgrupo.codominio.dominio.model.EnderecoModel;
import br.com.compraemgrupo.codominio.dominio.model.EstadoModel;

@Component
public class DominioBuilder {

	private CompradorModel comprador;
	private EnderecoModel endereco;
	private CidadeModel cidade;
	private EstadoModel estado;
	private Set<String> telefones = new HashSet<>();
	
	public DominioBuilder() {
		this.comprador = new CompradorModel();
		this.endereco = new EnderecoModel();
		this.cidade = new CidadeModel();
		this.estado = new EstadoModel();
	}
	
	public static DominioBuilder builder() {
		return new DominioBuilder();
	}
	
	public DominioBuilder adicionarComprador(CompradorDto dto) {
		this.comprador = new CompradorModel();
		this.comprador.setCpfOuCnpj(dto.getCpfOuCnpj());
		this.comprador.setDataCadastro(Calendar.getInstance().getTime());
		this.comprador.setEmail(dto.getEmail());
		this.comprador.setNome(dto.getNome());
		this.comprador.setSobrenome(dto.getSobrenome());
		this.comprador.setTipoComprador(dto.getTipoComprador());
		return this;
	}
	
	public DominioBuilder adicionarEndereco(CompradorDto dto) {
		this.endereco = new EnderecoModel();
		this.endereco.setBairro(dto.getBairro());
		this.endereco.setCep(dto.getCep());
		this.endereco.setComplemento(dto.getComplemento());
		this.endereco.setLogradouro(dto.getLogradouro());
		this.endereco.setNumero(dto.getNumero());
		this.endereco.setComprador(this.comprador);
		this.endereco.setCidade(this.cidade);
		return this;
	}
	
	public DominioBuilder adicionarCidade(CompradorDto dto) {
		this.cidade = new CidadeModel();
		this.cidade.setNome(dto.getNomeCidade());
		this.cidade.setId(dto.getIdCidade());
		this.cidade.setEstado(this.estado);
		return this;
	}
	
	public DominioBuilder adicionarEstado (CompradorDto dto) {
		this.estado = new EstadoModel();
		this.estado.setSigla(dto.getNomeEstado());
		this.estado.setId(dto.getIdEstado());
		return this;
	}
	
	public DominioBuilder adicionarTelefone (CompradorDto dto) {
		this.telefones.add(dto.getTelefone1());
		this.telefones.add(dto.getTelefone2());
		return this;
	}
	
	public CompradorModel get() {
		this.comprador.setTelefones(this.telefones);
		this.comprador.adicionarEndereco(this.endereco);
		
		return this.comprador;
	}
	
}
