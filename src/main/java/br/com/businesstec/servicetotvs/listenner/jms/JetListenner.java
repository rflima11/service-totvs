package br.com.businesstec.servicetotvs.listenner.jms;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.model.entities.ControleExecucaoFluxoEntidade;
import br.com.businesstec.servicetotvs.events.ControleExecucaoFluxoEvent;
import br.com.businesstec.servicetotvs.events.ControleExecucaoFluxoEventJet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class JetListenner {

    private static final Logger logger = LoggerFactory.getLogger(JetListenner.class);

    private final ObjectMapper objectMapper;
    private final ApplicationEventPublisher applicationEventPublisher;


    public JetListenner(ObjectMapper objectMapper, ApplicationEventPublisher applicationEventPublisher) {
        this.objectMapper = objectMapper;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @RabbitListener(queues = "queue.Rm.Entrega")
    public void onMessage(String msg) {
        try {
            var controleExecucaoFluxoEntidade = objectMapper.readValue(msg, ControleExecucaoFluxoEntidade.class);
            applicationEventPublisher.publishEvent(new ControleExecucaoFluxoEventJet(this, controleExecucaoFluxoEntidade));
        }  catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }
    }

}
