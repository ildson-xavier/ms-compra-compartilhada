package br.com.compraemgrupo.cogrupo.infrastruct.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "COMPRADORES_GRUPO")
public class Comprador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	
	private String cpfOuCnpj;
	
	private Integer tipoComprador;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "grupo_id")
	private Grupo grupo;
	
	@OneToMany(mappedBy = "comprador")
	private List<ItemProposta> itemPropostas = new ArrayList<>();

	public Comprador () {}
	
	public Comprador(Long id, String nome, String sobrenome, String email, Set<String> telefones, String cpfOuCnpj,
			Integer tipoComprador) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipoComprador = tipoComprador;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Comprador)) {
			return false;
		}
		Comprador other = (Comprador) obj;
		return Objects.equals(id, other.id);
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<ItemProposta> getItemPropostas() {
		return itemPropostas;
	}

	public void setItemPropostas(List<ItemProposta> itemPropostas) {
		this.itemPropostas = itemPropostas;
	}

	
}
