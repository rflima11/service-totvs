package br.com.businesstec.servicetotvs.mapper;

import br.com.businesstec.servicetotvs.dto.RealizarConsultaParametrosDTO;
import br.com.businesstec.servicetotvs.wsdl.realizarconsulta.ObjectFactory;
import br.com.businesstec.servicetotvs.wsdl.realizarconsulta.RealizarConsultaSQL;

public class RealizaConsultaSQLParser {

    private RealizaConsultaSQLParser() { throw new IllegalStateException("Classe utilitária não deve ser instanciada"); }

    public static RealizarConsultaSQL getRequestRealizarConsultaSQL(RealizarConsultaParametrosDTO parametrosDTO) {
        var request = new RealizarConsultaSQL();
        var objectFactory = new ObjectFactory();
        request.setCodSentenca(objectFactory.createRealizarConsultaSQLCodSentenca(parametrosDTO.getCodSetenca()));
        request.setCodSistema(objectFactory.createRealizarConsultaSQLCodSistema(parametrosDTO.getCodSistema()));
        request.setParameters(objectFactory.createRealizarConsultaSQLParameters(parametrosDTO.getParameters()));
        request.setCodColigada(parametrosDTO.getCodColigada());
        return request;
    }
}
