//package com.asscache.asscache.producer;
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AssinaturaSucessoProdutor {
//    @Autowired private AmqpTemplate amqpTemplate;
//
//    public void geraResposta(String mensagem){
//        amqpTemplate.convertAndSend(
//                "assinatura-response-sucesso",
//                "assinatura-response-sucesso-rout-key",
//                mensagem
//        );
//    }
//}
