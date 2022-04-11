package br.com.businesstec.servicetotvs.repository;

import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControleExecucaoFluxoEntidadeRepository extends JpaRepository<ControleExecucaoFluxoEntidade, Long> {
}
