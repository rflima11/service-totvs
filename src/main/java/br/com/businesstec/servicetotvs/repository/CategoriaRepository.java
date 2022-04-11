package br.com.businesstec.servicetotvs.repository;

import br.com.businesstec.servicetotvs.model.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByIdentificadorOrigem(String identificadorOrigem);
}
