package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.servicetotvs.dto.RealizarConsultaParametrosDTO;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;

public interface ConsultaSqlService {

    RealizarConsultaSQLResponseDTO realizaConsulta(RealizarConsultaParametrosDTO parametros);

}
