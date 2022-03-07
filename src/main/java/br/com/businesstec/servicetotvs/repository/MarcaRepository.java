package br.com.businesstec.servicetotvs.repository;

import br.com.businesstec.servicetotvs.model.entidades.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
