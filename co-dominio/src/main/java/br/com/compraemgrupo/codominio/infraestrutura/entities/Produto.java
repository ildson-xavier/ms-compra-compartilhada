package br.com.compraemgrupo.codominio.infraestrutura.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private String marca;
	private String modelo;
	private String fabricante;
	
	@Temporal(TemporalType.DATE)
	private Date dataFabricacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	private BigDecimal valorDeMercado;
	private BigDecimal valorProposto;
	
	public Produto() {}

	public Produto(Long id, String nome, String descricao, String marca, String modelo, String fabricante,
			Date dataFabricacao, Date dataCadastro, BigDecimal valorDeMercado, BigDecimal valorProposto) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.marca = marca;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.dataFabricacao = dataFabricacao;
		this.dataCadastro = dataCadastro;
		this.valorDeMercado = valorDeMercado;
		this.valorProposto = valorProposto;
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
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the fabricante
	 */
	public String getFabricante() {
		return fabricante;
	}

	/**
	 * @param fabricante the fabricante to set
	 */
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	/**
	 * @return the dataFabricacao
	 */
	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	/**
	 * @param dataFabricacao the dataFabricacao to set
	 */
	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	/**
	 * @return the dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * @param dataCadastro the dataCadastro to set
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * @return the valorDeMercado
	 */
	public BigDecimal getValorDeMercado() {
		return valorDeMercado;
	}

	/**
	 * @param valorDeMercado the valorDeMercado to set
	 */
	public void setValorDeMercado(BigDecimal valorDeMercado) {
		this.valorDeMercado = valorDeMercado;
	}

	/**
	 * @return the valorProposto
	 */
	public BigDecimal getValorProposto() {
		return valorProposto;
	}

	/**
	 * @param valorProposto the valorProposto to set
	 */
	public void setValorProposto(BigDecimal valorProposto) {
		this.valorProposto = valorProposto;
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
		if (!(obj instanceof Produto)) {
			return false;
		}
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	
}
