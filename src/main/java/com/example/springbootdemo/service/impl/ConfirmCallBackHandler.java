package com.example.springbootdemo.service.impl;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @Description:通过实现ConfirmCallBack接口，消息发送到交换器Exchange后触发回调。
 */
public class ConfirmCallBackHandler implements RabbitTemplate.ConfirmCallback {
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("消息唯一标识：" + correlationData);
        System.out.println("确认结果：" + ack);
        if (!ack) {
            System.out.println("消息发送异常:" + cause);
        } else {
            System.out.println("消息发送成功:" + cause);
        }
    }
}
