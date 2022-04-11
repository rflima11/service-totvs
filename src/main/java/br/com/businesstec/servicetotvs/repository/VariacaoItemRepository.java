package br.com.businesstec.servicetotvs.repository;

import br.com.businesstec.servicetotvs.model.entidades.VariacaoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariacaoItemRepository extends JpaRepository<VariacaoItem, Long> {

    boolean existsByIdentificadorOrigem(String identificadorOrigem);

    VariacaoItem findByIdentificadorOrigem(String identificadorOrigem);
}
