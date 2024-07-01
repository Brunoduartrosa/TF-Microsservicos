package com.asscache.asscache.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
    private static final String queueName = "scaa.v1.subscription-update.save-signature" + Math.random() * 1000;

    @Bean
    public Queue uniqueQueue() {
        return new Queue(queueName);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("atualiza-assinatura");
    }

    @Bean
    public Binding fanoutBinding(Queue uniqueQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(uniqueQueue).to(fanoutExchange);
    }

    @Bean
    public Declarables fanoutBindings(Queue uniqueQueue, FanoutExchange fanoutExchange, Binding fanoutBinding) {
        return new Declarables(uniqueQueue, fanoutExchange, fanoutBinding);
    }

    @Bean
    public MessageConverter converter()
    {
        return new Jackson2JsonMessageConverter();
    }

    public String getQueueName()
    {
        return queueName;
    }

}
