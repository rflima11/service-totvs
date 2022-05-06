package br.com.businesstec.servicetotvs.listenner.jms;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class JetListenner {

    @RabbitListener(queues = "queue.Pedidos")
    public void onMessage(String msg) {
        System.out.println(msg);
    }

}
