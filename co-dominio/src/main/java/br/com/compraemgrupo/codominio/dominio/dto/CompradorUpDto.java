package br.com.compraemgrupo.codominio.dominio.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.compraemgrupo.codominio.dominio.model.EnderecoModel;

public class CompradorUpDto {

	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	
	private Set<String> telefones = new HashSet<>();
	private String cpfOuCnpj;
	
	private Integer tipoComprador;
	
	private List<EnderecoModel> endereco = new ArrayList<>();

	private Date dataCadastro;

	public CompradorUpDto () {}
	
	public CompradorUpDto(Long id, String nome, String sobrenome, String email, Set<String> telefones, String cpfOuCnpj,
			Integer tipoComprador, List<EnderecoModel> endereco, Date dataCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefones = telefones;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipoComprador = tipoComprador;
		this.endereco = endereco;
		this.setDataCadastro(dataCadastro);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Integer getTipoComprador() {
		return tipoComprador;
	}

	public void setTipoComprador(Integer tipoComprador) {
		this.tipoComprador = tipoComprador;
	}
	
	public List<EnderecoModel> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<EnderecoModel> endereco) {
		this.endereco = endereco;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
