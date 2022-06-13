package br.com.businesstec.servicetotvs.mapper;


import br.com.businesstec.servicetotvs.dto.SaveRecordParametrosDTO;
import br.com.businesstec.servicetotvs.dto.SvRecordTest;
import br.com.businesstec.servicetotvs.utils.SoapUtils;
import br.com.businesstec.servicetotvs.wsdl.wsdataserver.ObjectFactory;
import br.com.businesstec.servicetotvs.wsdl.wsdataserver.SaveRecord;
import com.sun.xml.bind.marshaller.CharacterEscapeHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import static br.com.businesstec.servicetotvs.utils.SoapUtils.formatarRequestSaveRecord;

public class SaveRecordSQLParser {

    private SaveRecordSQLParser() { throw new IllegalStateException("Classe utilitária não deve ser instanciada"); }

    private static final String CONTEXTO_VALUE = "CODCOLIGADA=1;CODUSUARIO=integracaoJet";

    public static SaveRecord getRequestSaveRecord(SaveRecordParametrosDTO saveRecordParametrosDTO) {

        try {
            var request = new SaveRecord();
            var objectFactory = new ObjectFactory();
            request.setContexto(objectFactory.createSaveRecordContexto(CONTEXTO_VALUE));
            request.setDataServerName(objectFactory.createSaveRecordDataServerName("FinCFODataBR"));


            SvRecordTest sv = new SvRecordTest();
            sv.setBody(formatarRequestSaveRecord(saveRecordParametrosDTO));

            String xmlAsString = "";
            JAXBContext context = JAXBContext.newInstance(SvRecordTest.class);
            Marshaller m = context.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.setProperty(Marshaller.JAXB_FRAGMENT, true);
            m.setProperty(CharacterEscapeHandler.class.getName(), new CharacterEscapeHandler() {
                public void escape(char[] ac, int i, int j, boolean flag,
                                   Writer writer) throws IOException {
                    writer.write( ac, i, j ); }
            });

            var sw = new StringWriter();
            m.marshal(sv, sw);
            xmlAsString = sw.toString();
            request.setXML(objectFactory.createSaveRecordXML(formatarRequestSaveRecord(saveRecordParametrosDTO)));
            return request;

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("ABLABLAUE");

    }


}
