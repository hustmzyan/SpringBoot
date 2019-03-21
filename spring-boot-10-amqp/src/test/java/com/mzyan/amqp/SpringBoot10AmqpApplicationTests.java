package com.mzyan.amqp;

import com.mzyan.amqp.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot10AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    /**
     * 1、单播（点对点）
     */
    @Test
    public void contextLoads() {
        // Message 需要自己构造，定义消息体和消息内容
        //rabbitTemplate.send(exchange, routingKey, message);
        //只需要传入要发送的对象，自动序列化，保存并发送给RabbitMQ
        //rabbitTemplate.convertAndSend(exchange, routingKey, object);

        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("helloworld", 123, true));
        // 对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct", "mzyan.news", new Book("西游记","吴承恩"));
    }


    // 接收数据
    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("mzyan.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }


    /**
     * 2、广播
     */
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("三国演义","罗贯中"));
    }

    @Test
    public void createExchange(){
//        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
//        System.out.println("创建完成...");
//        amqpAdmin.declareQueue(new Queue("amqpadmin.queue", true));

        //创建绑定规则
        amqpAdmin.declareBinding(new Binding(
                "amqpadmin.queue",
                Binding.DestinationType.QUEUE,
                "amqpadmin.exchange",
                "amqp.haha",
                null));
    }
}
