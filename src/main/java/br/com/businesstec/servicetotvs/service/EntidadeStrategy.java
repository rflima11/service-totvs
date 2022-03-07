package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.enums.NomeStrategy;

public interface EntidadeStrategy {

    void salvar(RealizarConsultaSQLResponseDTO realizarConsultaSQLResponseDTO);

    NomeStrategy getNomeStrategy();
}
