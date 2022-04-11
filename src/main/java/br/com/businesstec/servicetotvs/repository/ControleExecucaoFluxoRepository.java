package br.com.businesstec.servicetotvs.repository;

import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ControleExecucaoFluxoRepository extends JpaRepository<ControleExecucaoFluxo, Long> {

    @Query(value = "select id_tipo_entidade from ctrl_fluxo cf \n" +
            "join ctrl_execucao_fluxo cef on cef.id_ctrl_fluxo = cf.id \n" +
            "where cef.id = :idCtrlExecucaoFluxo", nativeQuery = true)
    Long findIdTipoEntidadeByIdCtrlExecucaoFluxo(@Param("idCtrlExecucaoFluxo") Long idCtrlExecucaoFluxo);

    Optional<ControleExecucaoFluxo> findTopByErroFalseOrderByDataHoraDesc();

}
