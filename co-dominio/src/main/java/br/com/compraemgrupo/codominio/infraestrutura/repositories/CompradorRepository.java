package br.com.compraemgrupo.codominio.infraestrutura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compraemgrupo.codominio.infraestrutura.entities.Comprador;

public interface CompradorRepository extends JpaRepository<Comprador, Long> {

}
