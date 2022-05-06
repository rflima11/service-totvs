package br.com.businesstec.servicetotvs.mapper;


import br.com.businesstec.servicetotvs.dto.SaveRecordParametrosDTO;
import br.com.businesstec.servicetotvs.wsdl.wsdataserver.ObjectFactory;
import br.com.businesstec.servicetotvs.wsdl.wsdataserver.SaveRecord;

public class SaveRecordSQLParser {

    private SaveRecordSQLParser() { throw new IllegalStateException("Classe utilitária não deve ser instanciada"); }

    private static final String CONTEXTO_VALUE = "CODCOLIGADA=1;CODUSUARIO=integracaoJet";

    public static SaveRecord getRequestSaveRecord(SaveRecordParametrosDTO saveRecordParametrosDTO) {
        var request = new SaveRecord();
        var objectFactory = new ObjectFactory();
        request.setContexto(objectFactory.createSaveRecordContexto(CONTEXTO_VALUE));
        request.setDataServerName(objectFactory.createSaveRecordDataServerName(""));
        request.setXML(objectFactory.createSaveRecordXML("xml as String"));



        return request;
    }


}
