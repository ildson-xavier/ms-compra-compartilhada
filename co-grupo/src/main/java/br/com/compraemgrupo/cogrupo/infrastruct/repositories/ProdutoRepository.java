package br.com.compraemgrupo.cogrupo.infrastruct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compraemgrupo.cogrupo.infrastruct.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
