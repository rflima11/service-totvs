package br.com.businesstec.servicetotvs.utils;

import br.com.businesstec.servicetotvs.config.JaxbXmlConfiguration;
import br.com.businesstec.servicetotvs.dto.*;
import br.com.businesstec.servicetotvs.wsdl.realizarconsulta.RealizarConsultaSQLResponse;
import br.com.businesstec.servicetotvs.wsdl.wsdataserver.ObjectFactory;
import br.com.businesstec.servicetotvs.wsdl.wsdataserver.SaveRecord;
import com.sun.xml.bind.v2.runtime.XMLSerializer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class SoapUtils {

    private SoapUtils() { throw new IllegalStateException("Classe utilitária não deve ser instanciada"); }

    public static String jaxbObjectToXML(SaveRecordParametrosDTO request) {
        String xmlString = "";
        try {
            JAXBContext context = JAXBContext.newInstance(SaveRecordParametrosDTO.class);
            Marshaller m = context.createMarshaller();

            m.setProperty(
                    "com.sun.xml.bind.marshaller.CharacterEscapeHandler",
                    new JaxbXmlConfiguration());
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.setProperty(Marshaller.JAXB_FRAGMENT, true);


            var sw = new StringWriter();
            m.marshal(request, sw);
            xmlString = sw.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlString.substring(0, xmlString.length() - 21) + "</FinCFOBR>]]>";
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

    public static void main(String[] args) throws JAXBException {
//        JAXBContext context = JAXBContext.newInstance(SaveRecord.class);
//        Marshaller m = context.createMarshaller();
//
//        var request = new SaveRecord();
//        var objectFactory = new ObjectFactory();
//        request.setContexto(objectFactory.createSaveRecordContexto("contexto"));
//        request.setDataServerName(objectFactory.createSaveRecordDataServerName(""));
//        request.setXML(objectFactory.createSaveRecordXML("xml as String"));
//
//        var sw = new StringWriter();
//        m.marshal(request, sw);
//        var pei = sw.toString();
//
//        System.out.println(pei);


        var b = new SaveRecordParametrosDTO();
        var parametros = new ParametrosCliente();
        parametros.setCodColigada(1L);
        var parametrosCompl = new ParametrosClienteComplementares();
        b.setParametrosComplementares(parametrosCompl);
        b.setParametrosCliente(parametros);
        var xmlAsString = SoapUtils.jaxbObjectToXML(b);


        System.out.println(xmlAsString);

    }

//    <![CDATA[<FinCFOBR >
//    </FinCFOBR>]]>
}
