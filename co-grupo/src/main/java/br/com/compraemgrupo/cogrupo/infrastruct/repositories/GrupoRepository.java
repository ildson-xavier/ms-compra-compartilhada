package br.com.compraemgrupo.cogrupo.infrastruct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compraemgrupo.cogrupo.infrastruct.entities.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Long>{

	
}
