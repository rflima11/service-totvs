package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;

public interface EntidadeStrategy {

    void salvar(RealizarConsultaSQLResponseDTO realizarConsultaSQLResponseDTO, ControleExecucaoFluxo controleExecucaoFluxo);

    EnumNomeStrategy getNomeStrategy();
}
