package br.com.compraemgrupo.codominio.infraestrutura.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estados")
public class Estado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String uf;
	private String nome;
	
	@OneToMany(mappedBy = "estado")
	private List<Cidade> cidades = new ArrayList<>();
	
	public Estado () {}

	public Estado(Long id, String uf, String nome) {
		super();
		this.id = id;
		this.setUf(uf);
		this.setNome(nome);;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
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
		if (!(obj instanceof Estado)) {
			return false;
		}
		Estado other = (Estado) obj;
		return Objects.equals(id, other.id);
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	} 
	

//	
//	Joao de Carvalho. 2
//	Nestou de Camargo 1.
}
