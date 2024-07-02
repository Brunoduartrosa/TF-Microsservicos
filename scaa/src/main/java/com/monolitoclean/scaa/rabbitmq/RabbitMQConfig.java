//package com.monolitoclean.scaa.rabbitmq;
//
//import com.monolitoclean.scaa.domain.entities.AssinaturaModel;
//import org.springframework.amqp.core.Declarables;
//import org.springframework.amqp.core.FanoutExchange;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import static org.apache.coyote.http11.Constants.a;
//
//@Configuration
//public class RabbitMQConfig {
//
//    @Bean
//    public Declarables fanoutBindings(){
//        FanoutExchange fanoutExchange = new FanoutExchange("atualiza-assinatura");
//        return new Declarables(fanoutExchange);
//    }
//
//    public
//
//    @Bean
//    public MessageConverter converter(){
//        return new Jackson2JsonMessageConverter();
//    }
//}
