/*
package com.example.springbootdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DelayedRabbitMQConfig {
    public static final String DELAYED_QUEUE = "delay.queue";
    public static final String DELAYED_EXCHANGE = "delay.exchange";
    public static final String DELAYED_ROUTING_KEY = "delay.key";

    @Bean
    public Queue delayQueue() {
        return new Queue(DELAYED_QUEUE);
    }

    @Bean
    public CustomExchange delayExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(DELAYED_EXCHANGE, "x-delayed-message", true, false, args);
    }

    @Bean
    public Binding delayBinding(@Qualifier("delayQueue") Queue queue,
                                 @Qualifier("delayExchange") CustomExchange customExchange) {
        return BindingBuilder.bind(queue).to(customExchange).with(DELAYED_ROUTING_KEY).noargs();
    }
}*/
