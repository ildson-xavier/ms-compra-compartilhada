package br.com.compraemgrupo.cogrupo.infrastruct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compraemgrupo.cogrupo.infrastruct.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
