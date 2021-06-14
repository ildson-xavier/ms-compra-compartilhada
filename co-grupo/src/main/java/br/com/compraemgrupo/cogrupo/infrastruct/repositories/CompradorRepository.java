package br.com.compraemgrupo.cogrupo.infrastruct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compraemgrupo.cogrupo.infrastruct.entities.Comprador;

public interface CompradorRepository extends JpaRepository<Comprador, Long>{

}
