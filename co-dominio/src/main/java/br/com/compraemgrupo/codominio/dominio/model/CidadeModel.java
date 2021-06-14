package br.com.compraemgrupo.codominio.dominio.model;

import java.io.Serializable;
import java.util.Objects;

public class CidadeModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
	private EstadoModel estado;
	
	public CidadeModel () {}

	public CidadeModel(Long id, String nome, EstadoModel estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
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
	 * @return the estado
	 */
	public EstadoModel getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoModel estado) {
		this.estado = estado;
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
		if (!(obj instanceof CidadeModel)) {
			return false;
		}
		CidadeModel other = (CidadeModel) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", estado=" + estado + "]";
	}
	
	
}
