//package com.asscache.asscache.consumer;
//
//import com.asscache.asscache.producer.PagamentoErroProdutor;
//import com.asscache.asscache.producer.PagamentoSucessoProdutor;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
//import java.util.Random;
//
//@Component
//public class PagamentoRequest {
//    @Autowired private PagamentoSucessoProdutor sucessoProdutor;
//    @Autowired private PagamentoErroProdutor erroProdutor;
//
//    @RabbitListener(queues = {"pagamento-request-queue"})
//    public void receberMensagem(@Payload Message message){
//        System.out.println(message);
//        if (new Random().nextBoolean()){
//            sucessoProdutor.gerarResposta("Pagamento recebido com sucesso " + message);
//        }else {
//            erroProdutor.gerarResposta("ERRO no pagamento " + message);
//        }
//    }
//}
