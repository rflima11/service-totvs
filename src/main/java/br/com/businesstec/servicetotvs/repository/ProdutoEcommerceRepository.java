package br.com.businesstec.servicetotvs.repository;

import br.com.businesstec.servicetotvs.model.entidades.Produto;
import br.com.businesstec.servicetotvs.model.entidades.ProdutoEcommerce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoEcommerceRepository extends JpaRepository<ProdutoEcommerce, Long> {

    Optional<ProdutoEcommerce> findByIdProduto(Long idProduto);
}
