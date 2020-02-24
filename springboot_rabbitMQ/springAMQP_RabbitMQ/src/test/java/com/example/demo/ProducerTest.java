package com.example.demo;

import com.example.demo.entity.Order;
import com.example.demo.producer.RabbitSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerTest {

    @Autowired
    private RabbitSender rabbitSender;

    @Test
    public void testSend() throws Exception{
        Order order = new Order("123","第一个订单");
        rabbitSender.send(order);
    }
}
