package br.com.businesstec.servicetotvs.utils;

import br.com.businesstec.servicetotvs.dto.RealizarConsultaParametrosDTO;
import br.com.businesstec.servicetotvs.wsdl.RealizarConsultaSQLResponse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class  SoapUtils {

    private SoapUtils() { throw new IllegalStateException("Classe utilitária não deve ser instanciada"); }

    public static String jaxbObjectToXML(RealizarConsultaSQLResponse response) {
        String xmlString = "";
        try {
            JAXBContext context = JAXBContext.newInstance(RealizarConsultaParametrosDTO.class);
            Marshaller m = context.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            var sw = new StringWriter();
            m.marshal(response, sw);
            xmlString = sw.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlString;
    }
}
