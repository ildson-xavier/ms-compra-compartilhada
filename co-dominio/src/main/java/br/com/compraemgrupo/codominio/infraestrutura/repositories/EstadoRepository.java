package br.com.compraemgrupo.codominio.infraestrutura.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.compraemgrupo.codominio.infraestrutura.entities.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

	Optional<Estado> findByUf(@Param("uf") String uf);
}
