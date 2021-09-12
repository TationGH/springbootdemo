package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.config.DelayedRabbitMQConfig;
import com.example.springbootdemo.config.RabbitmqConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
public class RabbitmqReceiver {
    /*@RabbitListener(queues = RabbitmqConfig.SIMPLE_QUEUE)
    public void simpleReceive(String message, Channel channel) throws IOException {
        System.out.println("接收消息:" + message);
        channel.basicAck(1L, false);
    }*/

    @RabbitListener(queues = RabbitmqConfig.PS_QUEUE_1)
    public void psReceive1(String message) {
        System.out.println(RabbitmqConfig.PS_QUEUE_1 + "接收消息:" + message);
    }

    @RabbitListener(queues = RabbitmqConfig.PS_QUEUE_2)
    public void psReceive2(String message) {
        System.out.println(RabbitmqConfig.PS_QUEUE_2 + "接收消息:" + message);
    }

    @RabbitListener(queues = RabbitmqConfig.ROUTING_QUEUE_INFO)
    public void routingReceive1(String message, Channel channel, Message msg) throws IOException {
        System.out.println(RabbitmqConfig.ROUTING_QUEUE_INFO + "接收消息:" + message);
        channel.basicAck(msg.getMessageProperties().getDeliveryTag(), true);
    }

    @RabbitListener(queues = RabbitmqConfig.ROUTING_QUEUE_ERROR)
    public void routingReceive2(String message) {
        System.out.println(RabbitmqConfig.ROUTING_QUEUE_ERROR + "接收消息:" + message);
    }

    @RabbitListener(queues = RabbitmqConfig.TOPIC_COLOR_GREEN)
    public void topicReceive1(String message) {
        System.out.println(RabbitmqConfig.TOPIC_COLOR_GREEN + "接收消息:" + message);
    }

    @RabbitListener(queues = RabbitmqConfig.TOPIC_COLOR_ALL)
    public void topicReceive2(String message) {
        System.out.println(RabbitmqConfig.TOPIC_COLOR_ALL + "接收消息:" + message);
    }

    @RabbitListener(queues = DelayedRabbitMQConfig.DELAYED_QUEUE)
    public void delayReceive(Message message, Channel channel) throws IOException {
        String msg = new String(message.getBody());
        System.out.println(new Date().toString() + ">>接收延时消息：" + msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
