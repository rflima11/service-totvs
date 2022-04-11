package br.com.businesstec.servicetotvs.repository;

import br.com.businesstec.servicetotvs.model.entidades.CategoriaEcommerce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaEcommerceRepository extends JpaRepository<CategoriaEcommerce, Long> {

    Optional<CategoriaEcommerce> findByIdCategoria(Long idCategoria);

}
