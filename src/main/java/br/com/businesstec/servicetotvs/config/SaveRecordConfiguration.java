package br.com.businesstec.servicetotvs.config;

import br.com.businesstec.servicetotvs.config.properties.CharacterAdapter;
import br.com.businesstec.servicetotvs.config.properties.SoapProperties;
import br.com.businesstec.servicetotvs.utils.MyCdataInterceptor;
import com.sun.xml.bind.marshaller.CharacterEscapeHandler;
import com.sun.xml.bind.marshaller.DumbEscapeHandler;
import com.sun.xml.bind.marshaller.NoEscapeHandler;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import org.springframework.ws.transport.http.HttpUrlConnectionMessageSender;

import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
        Map<String, Object> properties = new HashMap<>();
        properties.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        properties.put(Marshaller.JAXB_FRAGMENT, true);
        properties.put(Marshaller.JAXB_ENCODING, "UTF-8");


        marshaller.setMarshallerProperties(properties);

        return marshaller;
    }




    @Bean("webServiceTemplateSaveRecord")
    public WebServiceTemplate webServiceTemplate(@Qualifier("marshallerSaveRecord") Jaxb2Marshaller marshaller) {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);
        webServiceTemplate.setDefaultUri(soapProperties.getDefaultUri().concat(soapProperties.getSaveRecord().getPath()));
        webServiceTemplate.setMessageSender(httpUrlConnectionMessageSender);

//        ClientInterceptor interceptor[] = new ClientInterceptor[1];
//        interceptor[0] = new MyCdataInterceptor();
//        webServiceTemplate.setInterceptors(interceptor);
        return webServiceTemplate;
    }
}
