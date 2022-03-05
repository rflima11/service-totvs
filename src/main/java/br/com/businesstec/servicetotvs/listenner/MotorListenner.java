package br.com.businesstec.servicetotvs.listenner;

import br.com.businesstec.servicetotvs.dto.ConsultaParametrosEnum;
import br.com.businesstec.servicetotvs.dto.RealizarConsultaParametrosDTO;
import br.com.businesstec.servicetotvs.model.ControleExecucaoFluxoTentativa;
import br.com.businesstec.servicetotvs.soap.RealizarConsultaSQLSoap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MotorListenner {

    private static final Logger logger = LoggerFactory.getLogger(MotorListenner.class);

    private final ObjectMapper objectMapper;
    private final RealizarConsultaSQLSoap realizarConsultaSQLSoap;

    @Value("${artemis.queue.fluxo}")
    private String queueName;

    public MotorListenner(ObjectMapper objectMapper, RealizarConsultaSQLSoap realizarConsultaSQLSoap) {
        this.objectMapper = objectMapper;
        this.realizarConsultaSQLSoap = realizarConsultaSQLSoap;
    }

    @JmsListener(destination = "queue.fluxo")
    public RealizarConsultaParametrosDTO zaga(String msg) {
        try {
            var obj = objectMapper.readValue(msg, ControleExecucaoFluxoTentativa.class);
            var param = new RealizarConsultaParametrosDTO(ConsultaParametrosEnum.COD_SETENCA_MARCAS.getValue(), obj.getDataHora());
            var resp = realizarConsultaSQLSoap.realizarConsulta(param);
            System.out.println(resp.getRealizarConsultaSQLResult().getValue());
            return null;
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            throw new RuntimeException("Não foi possível converter o objeto");
        }
    }
}
