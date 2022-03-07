package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.servicetotvs.dto.RealizarConsultaParametrosDTO;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.service.ConsultaSqlService;
import br.com.businesstec.servicetotvs.soap.RealizarConsultaSQLSoap;
import br.com.businesstec.servicetotvs.utils.SoapUtils;
import org.springframework.stereotype.Service;

@Service
public class ConsultaSqlServiceImpl implements ConsultaSqlService {

    private final RealizarConsultaSQLSoap realizarConsultaSQLSoap;

    public ConsultaSqlServiceImpl(RealizarConsultaSQLSoap realizarConsultaSQLSoap) {
        this.realizarConsultaSQLSoap = realizarConsultaSQLSoap;
    }

    @Override
    public RealizarConsultaSQLResponseDTO realizaConsulta(RealizarConsultaParametrosDTO parametros) {
        return SoapUtils.toResponseDTO(realizarConsultaSQLSoap.realizarConsulta(parametros).getRealizarConsultaSQLResult().getValue());
    }

}
