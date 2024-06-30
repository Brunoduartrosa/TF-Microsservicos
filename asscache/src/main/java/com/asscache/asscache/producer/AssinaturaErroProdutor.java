//package com.asscache.asscache.producer;
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AssinaturaErroProdutor {
//    @Autowired private AmqpTemplate amqpTemplate;
//
//    public void gerarResposta(String mensagem){
//        amqpTemplate.convertAndSend(
//                "assinatura-response-erro",
//                "assinatura-response-erro-rout-key",
//                mensagem
//        );
//    }
//}
