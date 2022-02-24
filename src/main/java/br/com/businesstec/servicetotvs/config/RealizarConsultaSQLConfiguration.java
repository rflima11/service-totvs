package br.com.businesstec.servicetotvs.config;

import br.com.businesstec.servicetotvs.config.properties.SoapProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpUrlConnectionMessageSender;

@Configuration
public class RealizarConsultaSQLConfiguration {

    private final SoapProperties soapProperties;
    private final HttpUrlConnectionMessageSender httpUrlConnectionMessageSender;

    public RealizarConsultaSQLConfiguration(SoapProperties soapProperties, HttpUrlConnectionMessageSender httpUrlConnectionMessageSender) {
        this.soapProperties = soapProperties;
        this.httpUrlConnectionMessageSender = httpUrlConnectionMessageSender;
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(soapProperties.getPackageWsdl());
        return marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(marshaller());
        webServiceTemplate.setUnmarshaller(marshaller());
        webServiceTemplate.setDefaultUri(soapProperties.getDefaultUri());
        webServiceTemplate.setMessageSender(httpUrlConnectionMessageSender);
        return webServiceTemplate;
    }

}
