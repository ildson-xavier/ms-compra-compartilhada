package br.com.compraemgrupo.codominio.infraestrutura.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comprador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	
	@ElementCollection
	@CollectionTable(name = "TELEFONE")
	private Set<String> telefones = new HashSet<>();
	
	private String cpfOuCnpj;
	
	private Integer tipoComprador;
	
	@OneToMany(mappedBy = "comprador", cascade=CascadeType.ALL)
	private List<Endereco> endereco = new ArrayList<>();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

	public Comprador () {}
	
	public Comprador(Long id, String nome, String sobrenome, String email, Set<String> telefones, String cpfOuCnpj,
			Integer tipoComprador, List<Endereco> endereco, Date dataCadastro) {
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

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	
}
