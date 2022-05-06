package br.com.businesstec.servicetotvs.soap;

import br.com.businesstec.servicetotvs.config.properties.SoapProperties;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaParametrosDTO;
import br.com.businesstec.servicetotvs.mapper.RealizaConsultaSQLParser;
import br.com.businesstec.servicetotvs.wsdl.realizarconsulta.RealizarConsultaSQLResponse;
import br.com.businesstec.servicetotvs.wsdl.wsdataserver.SaveRecordResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Component
public class SaveRecordSoap {

    private final WebServiceTemplate webServiceTemplate;
    private final SoapProperties soapProperties;

    public SaveRecordSoap(@Qualifier("webServiceTemplateSaveRecord") WebServiceTemplate webServiceTemplate, SoapProperties soapProperties) {
        this.webServiceTemplate = webServiceTemplate;
        this.soapProperties = soapProperties;
    }

    public SaveRecordResponse saveRecord(RealizarConsultaParametrosDTO parametrosDTO) {
        var request =  RealizaConsultaSQLParser.getRequestRealizarConsultaSQL(parametrosDTO);
        return (SaveRecordResponse) webServiceTemplate.marshalSendAndReceive(webServiceTemplate.getDefaultUri(),
                request, new SoapActionCallback(soapProperties.getSaveRecord().getAction()));
    }
}
