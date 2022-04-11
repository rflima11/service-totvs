package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.enums.EnumNomeStrategy;
import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxo;

public interface EntidadeStrategy {

    void salvar(RealizarConsultaSQLResponseDTO realizarConsultaSQLResponseDTO, ControleExecucaoFluxo controleExecucaoFluxo);

    EnumNomeStrategy getNomeStrategy();
}
