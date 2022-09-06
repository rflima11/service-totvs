package br.com.businesstec.servicetotvs.service.impl;

import br.com.businesstec.servicetotvs.dto.SaveRecordParametrosDTO;
import br.com.businesstec.servicetotvs.dto.SaveRecordRequest;
import br.com.businesstec.servicetotvs.service.SaveRecordService;
import br.com.businesstec.servicetotvs.soap.SaveRecordSoap;
import org.springframework.stereotype.Service;

@Service
public class SaveRecordServiceImpl implements SaveRecordService {

    private final SaveRecordSoap saveRecordSoap;

    public SaveRecordServiceImpl(SaveRecordSoap saveRecordSoap) {
        this.saveRecordSoap = saveRecordSoap;
    }

    public String salvarRegistro(SaveRecordRequest parametros) {
        var result = saveRecordSoap.saveRecord(parametros).getSaveRecordResult();
        return result.getValue();
    }
}
