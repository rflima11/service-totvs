package br.com.businesstec.servicetotvs.soap;

import br.com.businesstec.servicetotvs.config.properties.SoapProperties;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaParametrosDTO;
import br.com.businesstec.servicetotvs.dto.SaveRecordParametrosDTO;
import br.com.businesstec.servicetotvs.mapper.RealizaConsultaSQLParser;
import br.com.businesstec.servicetotvs.mapper.SaveRecordSQLParser;
import br.com.businesstec.servicetotvs.wsdl.realizarconsulta.RealizarConsultaSQLResponse;
import br.com.businesstec.servicetotvs.wsdl.wsdataserver.SaveRecordResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.w3c.dom.CDATASection;

import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMResult;
import java.io.IOException;

@Component
public class SaveRecordSoap {

    private final WebServiceTemplate webServiceTemplate;
    private final SoapProperties soapProperties;

    public SaveRecordSoap(@Qualifier("webServiceTemplateSaveRecord") WebServiceTemplate webServiceTemplate, SoapProperties soapProperties) {
        this.webServiceTemplate = webServiceTemplate;
        this.soapProperties = soapProperties;
    }

    public SaveRecordResponse saveRecord(SaveRecordParametrosDTO parametrosDTO) {
        var request =  SaveRecordSQLParser.getRequestSaveRecord(parametrosDTO);
        return (SaveRecordResponse) webServiceTemplate.marshalSendAndReceive(webServiceTemplate.getDefaultUri(),
                request, new SoapActionCallback(soapProperties.getSaveRecord().getAction()));
    }

    public WebServiceMessageCallback action(String action) {
        return new WebServiceMessageCallback() {
            @Override
            public void doWithMessage(WebServiceMessage webServiceMessage) throws

                    IOException, TransformerException {

                SoapMessage soapMessage = (SoapMessage)webServiceMessage;
                soapMessage.setSoapAction(action);
                var document = soapMessage.getDocument();
                var saaj = (SaajSoapMessage) soapMessage;

            }
        };
    }

}
