package br.com.businesstec.servicetotvs.config;

import br.com.businesstec.servicetotvs.config.properties.SoapProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpUrlConnectionMessageSender;

@Component
public class SaveRecordConfiguration {

    private final SoapProperties soapProperties;
    private final HttpUrlConnectionMessageSender httpUrlConnectionMessageSender;
    private static final String PACKAGE_WSDL = ".wsdataserver";

    public SaveRecordConfiguration(SoapProperties soapProperties, HttpUrlConnectionMessageSender httpUrlConnectionMessageSender) {
        this.soapProperties = soapProperties;
        this.httpUrlConnectionMessageSender = httpUrlConnectionMessageSender;
    }

    @Bean("marshallerSaveRecord")
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(soapProperties.getPackageWsdl().concat(PACKAGE_WSDL));
        return marshaller;
    }

    @Bean("webServiceTemplateSaveRecord")
    public WebServiceTemplate webServiceTemplate(@Qualifier("marshallerSaveRecord") Jaxb2Marshaller marshaller) {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);
        webServiceTemplate.setDefaultUri(soapProperties.getDefaultUri().concat(soapProperties.getSaveRecord().getPath()));
        webServiceTemplate.setMessageSender(httpUrlConnectionMessageSender);
        return webServiceTemplate;
    }
}
