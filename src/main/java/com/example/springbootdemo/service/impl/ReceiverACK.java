/*
package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.config.RabbitmqConfig;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = RabbitmqConfig.SIMPLE_QUEUE)
public class ReceiverACK {
    @RabbitHandler
    public void processHandler(String msg, Channel channel, Message message) throws IOException {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            System.out.println(RabbitmqConfig.SIMPLE_QUEUE + "接收消息:" + msg);
            //消息=0时，假定是重复消息，失败确认且抛弃消息
            if (msg.equals("0")) {
                System.out.println("basicReject：重复消息，失败确认且丢弃消息");
                channel.basicReject(deliveryTag ,false); //失败确认
                Thread.sleep(2000);
                return;
            }

            //成功确认
            channel.basicAck(deliveryTag, false);
            System.out.println("basicAck：成功确认"); Thread.sleep(2000);
        } catch (Exception e) {
            //异常时，失败确认且消息重回队列
            channel.basicNack(deliveryTag, false, true);//失败确认

            channel.basicPublish( RabbitmqConfig.SIMPLE_QUEUE, null, true, null, null);
            System.out.println("basicNack：失败确认且消息重回队列");
        }
    }
}
*/
