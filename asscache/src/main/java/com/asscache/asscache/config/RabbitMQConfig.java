//package com.asscache.asscache.config;
//
//import com.rabbitmq.client.ConnectionFactory;
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.FanoutExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitMQConfig {
//    public static final String QUEUENAME = "scaa.v1.subscription-update.save-signature\" + Math.random() * 1000";
//
//    @Bean
//    public Queue queue() {
//        return new Queue(QUEUENAME, true);
//    }
//
//    @Bean
//    public FanoutExchange fanoutExchange() {
//        return new FanoutExchange("scaa.subscription.exchange");
//    }
//
//    @Bean
//    public Binding binding(Queue queue, FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(queue).to(fanoutExchange);
//    }
//}
