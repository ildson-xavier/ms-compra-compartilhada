package br.com.compraemgrupo.codominio.infraestrutura.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.compraemgrupo.codominio.infraestrutura.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	List<Endereco> findByLogradouroContaining (@Param("logradouro") String logradouro);
}
