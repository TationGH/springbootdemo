/*
package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.config.DelayedRabbitMQConfig;
import com.example.springbootdemo.config.RabbitmqConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Component
public class RabbitmqSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    void rabbitTemplate() {
        //消息发送确认，发送到交换器Exchange后触发回调
        //rabbitTemplate.setConfirmCallback(new ConfirmCallBackHandler());
        //rabbitTemplate.setReturnsCallback(new ReturnsCallBackHandler());
    }

    */
/**
     * 简单模式发送
     *//*

    public void simpleSend(String message) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());//消息唯一标识
        MessageProperties messageProperties = new MessageProperties();
        //messageProperties.setExpiration("3000"); // 设置过期时间，单位：毫秒
        byte[] msgBytes = message.getBytes();
        Message msg = new Message(msgBytes, messageProperties);
        this.rabbitTemplate.convertAndSend(RabbitmqConfig.SIMPLE_QUEUE, msg, correlationData);
    }

    */
/**
     * 发布/订阅模式发送
     *//*

    public void psSend(String message) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());//消息唯一标识
        this.rabbitTemplate.convertAndSend(RabbitmqConfig.FANOUT_EXCHANGE, "", message, correlationData);
    }

    */
/**
     * 路由模式发送
     *//*

    public void routingSend(String routingKey, String message) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());//消息唯一标识
        this.rabbitTemplate.convertAndSend(RabbitmqConfig.DIRECT_EXCHANGE, routingKey, message, correlationData);
    }

    */
/**
     * 主题模式发送
     *//*

    public void topicSend(String routingKey, String message) {
        this.rabbitTemplate.convertAndSend(RabbitmqConfig.TOPIC_EXCHANGE, routingKey, message);
    }

    */
/**
     * 延迟发送
     *//*

    public void delaySend(String routingKey, String message, Integer delayTime) {
        System.out.println(new Date().toString() + ">>发送延时消息：" + message);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());//消息唯一标识
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setDelay(delayTime);//设置延迟时间，单位：毫秒
        byte[] msgBytes = message.getBytes();
        Message msg = new Message(msgBytes, messageProperties);
        this.rabbitTemplate.convertAndSend(DelayedRabbitMQConfig.DELAYED_EXCHANGE, routingKey, msg, correlationData);
    }
}
*/
