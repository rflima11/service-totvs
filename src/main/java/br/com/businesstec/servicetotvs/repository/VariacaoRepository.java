package br.com.businesstec.servicetotvs.repository;

import br.com.businesstec.servicetotvs.model.entidades.Variacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VariacaoRepository extends JpaRepository<Variacao, Long> {

    Variacao findByIdentificadorOrigem(String identificadorOrigem);

    boolean existsByIdentificadorOrigem(String identificadorOrigem);

}
