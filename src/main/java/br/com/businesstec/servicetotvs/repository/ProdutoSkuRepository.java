package br.com.businesstec.servicetotvs.repository;

import br.com.businesstec.servicetotvs.model.entidades.ProdutoSku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoSkuRepository extends JpaRepository<ProdutoSku, Long> {

    Optional<ProdutoSku> findByIdProduto(Long idProduto);

}
