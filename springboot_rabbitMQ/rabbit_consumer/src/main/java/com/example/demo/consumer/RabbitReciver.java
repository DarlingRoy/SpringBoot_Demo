package com.example.demo.consumer;

import com.example.demo.entity.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RabbitReciver {

//    @RabbitHandler
//    @RabbitListener(queues = {"queue-1"})
//    public void onOrderMessage(@Payload Order order, Channel channel, @Header Map<String, Object> headers) throws Exception{
//        System.out.println("消费端： "+order);
////        手工ACK
//        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
//        channel.basicAck(deliveryTag,false);
//    }
    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue-1",durable = "true"),
            exchange = @Exchange(value = "exchange-1",type = "topic",ignoreDeclarationExceptions = "true"),
            key = "springboot.#"
    ))
    public void onOrderMessage(Order order){
        System.out.println("消费端： " + order);
    }
}
