package com.monolitoclean.scaa.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConnection {
    private static final String NOME_EXCHANGE = "atualiza-assinatura";
    public Queue queue(String nome){
        return new Queue(nome, true, false, false);
    }

    public DirectExchange exchange() {
        return new DirectExchange(NOME_EXCHANGE);
    }

    public Binding binding(Queue queue, DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("");
    }
}
