package br.com.businesstec.servicetotvs.repository;

import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxoTentativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControleExecucaoFluxoTentativaRepository extends JpaRepository<ControleExecucaoFluxoTentativa, Long> {

}
