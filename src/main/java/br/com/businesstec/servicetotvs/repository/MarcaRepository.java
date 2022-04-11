package br.com.businesstec.servicetotvs.repository;

import br.com.businesstec.servicetotvs.model.entidades.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

    Optional<Marca> findByIdentificadorOrigem(String identificadorOrigem);

}
