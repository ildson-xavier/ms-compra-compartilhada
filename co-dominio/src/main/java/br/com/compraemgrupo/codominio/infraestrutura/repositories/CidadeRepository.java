package br.com.compraemgrupo.codominio.infraestrutura.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.compraemgrupo.codominio.infraestrutura.entities.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

	List<Cidade> findByNomeLikeIgnoreCase(@Param("nome") String nome);
	
	@Query("SELECT a FROM Cidade a INNER JOIN a.estado e where e.uf =:uf ")
	List<Cidade> findByUfIgnoreCase (@Param("uf") String uf);
}
