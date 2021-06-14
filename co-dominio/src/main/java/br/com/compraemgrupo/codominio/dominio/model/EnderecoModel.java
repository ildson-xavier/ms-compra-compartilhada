package br.com.compraemgrupo.codominio.dominio.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EnderecoModel implements Serializable{

	private static final long serialVersionUID = 1L;
	 
	private Long id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	
	@JsonIgnore
	private CompradorModel comprador;

	private CidadeModel cidade;
	
	public EnderecoModel() {}

	public EnderecoModel(Long id, String logradouro, String numero, String complemento, String bairro, String cep,
			CompradorModel comprador, CidadeModel cidade) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.comprador = comprador;
		this.cidade = cidade;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return the comprador
	 */
	public CompradorModel getComprador() {
		return comprador;
	}

	/**
	 * @param comprador the comprador to set
	 */
	public void setComprador(CompradorModel comprador) {
		this.comprador = comprador;
	}

	/**
	 * @return the cidade
	 */
	public CidadeModel getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(CidadeModel cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EnderecoModel)) {
			return false;
		}
		EnderecoModel other = (EnderecoModel) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", logradouro=" + logradouro + ", numero=" + numero + ", complemento="
				+ complemento + ", bairro=" + bairro + ", cep=" + cep + ", cidade="
				+ cidade + "]";
	}
	
	
}
