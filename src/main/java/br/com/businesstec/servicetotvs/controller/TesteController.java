package br.com.businesstec.servicetotvs.controller;

import br.com.businesstec.servicetotvs.dto.RealizarConsultaParametrosDTO;
import br.com.businesstec.servicetotvs.soap.RealizarConsultaSQLSoap;
import br.com.businesstec.servicetotvs.wsdl.RealizarConsultaSQLResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TesteController {

    private final RealizarConsultaSQLSoap soapClient;

    public TesteController(RealizarConsultaSQLSoap soapClient) {
        this.soapClient = soapClient;
    }

    @PostMapping
    public ResponseEntity<RealizarConsultaSQLResponse> realizarConsultaSQL(@RequestBody RealizarConsultaParametrosDTO realizarConsultaParametrosDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(soapClient.realizarConsulta(realizarConsultaParametrosDTO));
    }
}
