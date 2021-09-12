package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.config.RabbitmqConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AAA {
    @RabbitHandler
    public void processHandler(String msg, Channel channel, Message message) throws IOException {
        System.out.println("basicReject：重复消息，失败确认且抛弃消息");
        channel.basicReject(message.getMessageProperties().getDeliveryTag(), false); //失败确认
    }
}