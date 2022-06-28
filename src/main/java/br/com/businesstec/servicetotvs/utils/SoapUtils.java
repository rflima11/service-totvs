package br.com.businesstec.servicetotvs.utils;

import br.com.businesstec.servicetotvs.dto.*;
import com.sun.xml.bind.marshaller.CharacterEscapeHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public class SoapUtils {

    private SoapUtils() { throw new IllegalStateException("Classe utilitária não deve ser instanciada"); }

    public static String formatarRequestSaveRecord(SaveRecordParametrosDTO request) {
        String xmlString = "";
        try {
            JAXBContext context = JAXBContext.newInstance(SaveRecordParametrosDTO.class);
            Marshaller m = context.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.setProperty(Marshaller.JAXB_FRAGMENT, true);
            m.setProperty(CharacterEscapeHandler.class.getName(), new CharacterEscapeHandler() {
                public void escape(char[] ac, int i, int j, boolean flag,
                                   Writer writer) throws IOException {
                    writer.write( ac, i, j ); }
            });

            var sw = new StringWriter();
            m.marshal(request, sw);
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
