package br.com.compraemgrupo.codominio.dominio.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

public class CompradorDto {

	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;
	@NotEmpty(message = "{campo.sobrenome.obrigatorio}")
	private String sobrenome;
	@NotNull(message = "{campo.email.obrigatorio}")
	@Email(message = "{campo.email.invalido}")
	private String email;
	@CPF(message = "{campo.cpf.invalido}")
	private String cpfOuCnpj;
	private Integer tipoComprador;
	private String telefone1;
	private String telefone2;
	
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	
	private Long idEstado;
	private Long idCidade;
	private String nomeCidade;
	private String nomeEstado;
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}
	/**
	 * @param sobrenome the sobrenome to set
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the cpfOuCnpj
	 */
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}
	/**
	 * @param cpfOuCnpj the cpfOuCnpj to set
	 */
	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
	/**
	 * @return the tipoComprador
	 */
	public Integer getTipoComprador() {
		return tipoComprador;
	}
	/**
	 * @param tipoComprador the tipoComprador to set
	 */
	public void setTipoComprador(Integer tipoComprador) {
		this.tipoComprador = tipoComprador;
	}
	/**
	 * @return the telefone1
	 */
	public String getTelefone1() {
		return telefone1;
	}
	/**
	 * @param telefone1 the telefone1 to set
	 */
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	/**
	 * @return the telefone2
	 */
	public String getTelefone2() {
		return telefone2;
	}
	/**
	 * @param telefone2 the telefone2 to set
	 */
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
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
	 * @return the nomeCidade
	 */
	public String getNomeCidade() {
		return nomeCidade;
	}
	/**
	 * @param nomeCidade the nomeCidade to set
	 */
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	/**
	 * @return the nomeEstado
	 */
	public String getNomeEstado() {
		return nomeEstado;
	}
	/**
	 * @param nomeEstado the nomeEstado to set
	 */
	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}
	@Override
	public String toString() {
		return "CompradorDto [nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", cpfOuCnpj="
				+ cpfOuCnpj + ", tipoComprador=" + tipoComprador + ", telefone1=" + telefone1 + ", telefone2="
				+ telefone2 + ", logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento
				+ ", bairro=" + bairro + ", cep=" + cep + ", nomeCidade=" + nomeCidade + ", nomeEstado=" + nomeEstado
				+ "]";
	}
	public Long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}
	public Long getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}
	
	
}
