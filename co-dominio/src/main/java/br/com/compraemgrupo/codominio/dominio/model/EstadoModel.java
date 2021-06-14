package br.com.compraemgrupo.codominio.dominio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EstadoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String sigla;
	private String descricao;
	
	@JsonIgnore
	private List<CidadeModel> cidades = new ArrayList<>();
	
	public EstadoModel () {}

	public EstadoModel(Long id, String sigla, String descricao) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CidadeModel> getCidades() {
		return cidades;
	}

	public void setCidades(List<CidadeModel> cidades) {
		this.cidades = cidades;
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
		if (!(obj instanceof EstadoModel)) {
			return false;
		}
		EstadoModel other = (EstadoModel) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", sigla=" + sigla + "]";
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	} 
	
	
}
