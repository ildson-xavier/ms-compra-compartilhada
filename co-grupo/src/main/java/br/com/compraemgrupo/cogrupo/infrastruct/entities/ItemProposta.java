package br.com.compraemgrupo.cogrupo.infrastruct.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ITEM_PROPOSTA")
public class ItemProposta implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer quantidade;
	
	private BigDecimal valorUnitario;
	
	private BigDecimal valorTotal;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "comprador_id")
	private Comprador comprador;

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
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the valorUnitario
	 */
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	/**
	 * @param valorUnitario the valorUnitario to set
	 */
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	/**
	 * @return the valorTotal
	 */
	public BigDecimal getValorTotal() {
		this.valorTotal = this.valorUnitario.multiply(new BigDecimal(this.quantidade));
		return valorTotal;
	}

	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return the comprador
	 */
	public Comprador getComprador() {
		return comprador;
	}

	/**
	 * @param comprador the comprador to set
	 */
	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}
	
	
}
