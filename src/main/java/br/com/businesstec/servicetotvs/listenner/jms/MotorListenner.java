package br.com.businesstec.servicetotvs.listenner.jms;

import br.com.businesstec.model.entities.ControleExecucaoFluxo;
import br.com.businesstec.servicetotvs.events.ControleExecucaoFluxoEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MotorListenner {

    private static final Logger logger = LoggerFactory.getLogger(MotorListenner.class);

    private final ObjectMapper objectMapper;
    private final ApplicationEventPublisher applicationEventPublisher;

    public MotorListenner(ObjectMapper objectMapper, ApplicationEventPublisher applicationEventPublisher) {
        this.objectMapper = objectMapper;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @RabbitListener(queues = "queue.Rm")
    public void onMessage(String msg) {
        try {
            var controleExecucaoFluxo = objectMapper.readValue(msg, ControleExecucaoFluxo.class);
            applicationEventPublisher.publishEvent(new ControleExecucaoFluxoEvent(this, controleExecucaoFluxo));
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }
    }
}
