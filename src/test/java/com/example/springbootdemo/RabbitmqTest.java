/*
package com.example.springbootdemo;

import com.example.springbootdemo.service.impl.RabbitmqSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootdemoApplication.class})
public class RabbitmqTest {
    @Autowired
    private RabbitmqSender rabbitmqSender;

    @Test
    public void testSimpleSend() throws Exception {
        String message = "Hello World !";
        System.out.println("发送消息:" + 0);
        this.rabbitmqSender.simpleSend("0");
    }

    @Test
    public void testPsSend() throws Exception {
        for (int i = 0; i <= 1000; i++) {
            String message = "Hello World !" + i;
            System.out.println("发送消息:" + message);
            this.rabbitmqSender.psSend(message);
            //Thread.sleep(3000);//间隔1秒发送一次消息
        }
    }

    @Test
    public void testRoutingSend() throws Exception {
        for (int i = 0; i <= 1000; i++) {
            String message = "Hello World !" + i;
            System.out.println("发送消息:" + message);
            this.rabbitmqSender.routingSend("warning", message);
            Thread.sleep(3000);//间隔1秒发送一次消息
        }
    }

    @Test
    public void testTopicSend() throws Exception {
        for (int i = 0; i <= 1000; i++) {
            String message = "Hello World !" + i;
            System.out.println("发送消息:" + message);
            this.rabbitmqSender.topicSend("color.green", message);
            Thread.sleep(1000);//间隔1秒发送一次消息
        }
    }

    @Test
    public void testdelaySend() throws Exception {
        this.rabbitmqSender.delaySend("delay.key", "Hello World !", 3000);
        Thread.sleep(10000);//间隔1秒发送一次消息
    }
}*/
