package br.com.compraemgrupo.cogrupo.infrastruct.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "grupo")
public class Grupo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private Integer quantidadeDeVagas;
	
	private Integer vagasPreenchidas;
	
	private BigDecimal valorSomadoMercado;
	
	private BigDecimal valorSomadoProposto;
	
	private BigDecimal valorAtualizado;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtulizacao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	@OneToMany(mappedBy = "grupo")
	private List<Comprador> compradores = new ArrayList<>();

	public void adicionarComprador(Comprador comprador) {
		this.getCompradores().add(comprador);
		this.dataAtulizacao = Calendar.getInstance().getTime();
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
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return "Grupo [id=" + id + ", nome=" + nome + ", categoria=" + categoria + "]";
	}

	public List<Comprador> getCompradores() {
		return compradores;
	}

	public void setCompradores(List<Comprador> compradores) {
		this.compradores = compradores;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtulizacao() {
		return dataAtulizacao;
	}

	public void setDataAtulizacao(Date dataAtulizacao) {
		this.dataAtulizacao = dataAtulizacao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidadeDeVagas() {
		return quantidadeDeVagas;
	}

	public void setQuantidadeDeVagas(Integer quantidadeDeVagas) {
		this.quantidadeDeVagas = quantidadeDeVagas;
	}

	public Integer getVagasPreenchidas() {
		this.vagasPreenchidas = this.compradores.size();
		return vagasPreenchidas;
	}

	public void setVagasPreenchidas(Integer vagasPreenchidas) {
		this.vagasPreenchidas = vagasPreenchidas;
	}

	public BigDecimal getValorSomadoMercado() {
		if (this.produto != null) {
			this.valorSomadoMercado = this.produto.getValorDeMercado().multiply(new BigDecimal(this.getQuantidadeDeVagas()));
		}
		return valorSomadoMercado;
	}

	public void setValorSomadoMercado(BigDecimal valorSomadoMercado) {
		this.valorSomadoMercado = valorSomadoMercado;
	}

	public BigDecimal getValorSomadoProposto() {
		if (this.produto != null) {
			this.valorSomadoProposto = this.produto.getValorProposto().multiply(new BigDecimal(this.getQuantidadeDeVagas()));
		}
		return valorSomadoProposto;
	}

	public void setValorSomadoProposto(BigDecimal valorSomadoProposto) {
		this.valorSomadoProposto = valorSomadoProposto;
	}

	public BigDecimal getValorAtualizado() {
		if (this.produto != null) {
			Integer qtdCompradores = this.compradores.size();
			this.valorAtualizado = this.produto.getValorProposto().multiply(new BigDecimal(qtdCompradores));
		}
		return valorAtualizado;
	}

	public void setValorAtualizado(BigDecimal valorAtualizado) {
		this.valorAtualizado = valorAtualizado;
	}
	
}
