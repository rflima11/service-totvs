package br.com.businesstec.servicetotvs.repository;

import br.com.businesstec.servicetotvs.model.entidades.MarcaEcommerce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarcaEcommerceRepository extends JpaRepository<MarcaEcommerce, Long> {

    Optional<MarcaEcommerce> findByIdMarca(Long idMarca);
}
