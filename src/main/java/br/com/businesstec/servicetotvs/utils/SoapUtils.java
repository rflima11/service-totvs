package br.com.businesstec.servicetotvs.utils;

import br.com.businesstec.servicetotvs.dto.RealizarConsultaParametrosDTO;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaSQLResponseDTO;
import br.com.businesstec.servicetotvs.wsdl.realizarconsulta.RealizarConsultaSQLResponse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class SoapUtils {

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

    public static RealizarConsultaSQLResponseDTO toResponseDTO(String xmlString) {
        try {
            var jaxbContext = JAXBContext.newInstance(RealizarConsultaSQLResponseDTO.class);
            var unmarshaller = jaxbContext.createUnmarshaller();
            return (RealizarConsultaSQLResponseDTO) unmarshaller.unmarshal(new StringReader(xmlString));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
