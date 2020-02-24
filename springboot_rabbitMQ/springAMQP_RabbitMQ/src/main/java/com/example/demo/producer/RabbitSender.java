package com.example.demo.producer;

import com.example.demo.entity.Order;
import com.rabbitmq.client.ConfirmCallback;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    final RabbitTemplate.ConfirmCallback confirmCallback = (correlationData, ack, s) -> {
        System.out.println("correlationData: "+correlationData);
        System.out.println("ack: "+ack);
    };

    final RabbitTemplate.ReturnCallback returnCallback= (message, replyCode, replyText, exchange, routingKey) -> System.out.println("return exchange: "+exchange+" , routingKey: "
            +routingKey+" , replyCode: "+replyCode+" ,replyText: "+replyText);

    public void send(Order order){
//        使用RabbitMQ的confirm机制
        rabbitTemplate.setConfirmCallback(confirmCallback);
//        使用RabbitMQ的return机制
        rabbitTemplate.setReturnCallback(returnCallback);
//        id+时间戳全局唯一
        CorrelationData correlationData=new CorrelationData("123456789");
//        生产端发送消息，指定Exchange和Routing Key
        rabbitTemplate.convertAndSend("exchange-1","springboot.hello",order,correlationData);
    }
}
