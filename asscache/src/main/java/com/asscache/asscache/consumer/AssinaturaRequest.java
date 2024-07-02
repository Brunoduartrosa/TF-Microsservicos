package com.asscache.asscache.consumer;

import com.asscache.asscache.domain.data.StatusAssinatura;
import com.asscache.asscache.model.AtualizacaoStatusAssinatura;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class AssinaturaRequest {

    private final StatusAssinatura statusAssinatura;

    public AssinaturaRequest(StatusAssinatura statusAssinatura) {
        this.statusAssinatura = statusAssinatura;
    }

    @RabbitListener(queues = "atualiza-assinatura-queue")
    public void receberAtualizacaoStatusAssinatura(@Payload AtualizacaoStatusAssinatura atualizacaoStatusAssinatura){
        statusAssinatura.atualizaStatusAssinatura(atualizacaoStatusAssinatura.codass(), atualizacaoStatusAssinatura.novoFimVigencia());
    }
}

