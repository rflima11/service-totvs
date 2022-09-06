package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.servicetotvs.dto.SaveRecordParametrosDTO;
import br.com.businesstec.servicetotvs.dto.SaveRecordRequest;

public interface SaveRecordService {

    String salvarRegistro(SaveRecordRequest parametrosDTO);
}
