package br.com.businesstec.servicetotvs.parser;

import br.com.businesstec.servicetotvs.dto.RealizarConsultaParametrosDTO;
import br.com.businesstec.servicetotvs.wsdl.ObjectFactory;
import br.com.businesstec.servicetotvs.wsdl.RealizarConsultaSQL;

public class RealizaConsultaSQLParser {

    private RealizaConsultaSQLParser() { throw new IllegalStateException("Classe utilitária não deve ser instanciada"); }

    public static RealizarConsultaSQL getRequestRealizarConsultaSQL(RealizarConsultaParametrosDTO parametrosDTO) {
        var request = new RealizarConsultaSQL();
        var objectFactory = new ObjectFactory();
        request.setCodSentenca(objectFactory.createRealizarConsultaSQLCodSentenca(parametrosDTO.getCodSetenca()));
        request.setCodSistema(objectFactory.createRealizarConsultaSQLCodSistema(parametrosDTO.getCodSistema()));
        request.setParameters(objectFactory.createRealizarConsultaSQLParameters(parametrosDTO.getDatasincParameter()));
        request.setCodColigada(parametrosDTO.getCodColigada());
        return request;
    }
}
