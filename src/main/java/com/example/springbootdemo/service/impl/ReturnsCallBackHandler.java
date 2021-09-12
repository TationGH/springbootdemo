package com.example.springbootdemo.service.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class ReturnsCallBackHandler implements RabbitTemplate.ReturnsCallback {
    @Override
    public void returnedMessage(ReturnedMessage rtMsg) {
        System.out.println("消息主体：" + rtMsg.getMessage());
        System.out.println("交换机：" + rtMsg.getExchange());
        System.out.println("路由键：" + rtMsg.getRoutingKey());
        System.out.println("应答码: ：" + rtMsg.getReplyCode());
        System.out.println("错误原因：" + rtMsg.getReplyText());
    }
}
