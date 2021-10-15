/*
package com.example.springbootdemo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitmqConfig {
    //=============死信===============
    public static final String DEAD_LETTER_EXCHANGE = "dead_letter_exchange";
    public static final String DEAD_LETTER_QUEUE = "dead_letter_queue";
    public static final String DEAD_LETTER_ROUTING_KEY = "DLX";

    @Bean
    public DirectExchange deadLetterExchange(){
        return new DirectExchange(DEAD_LETTER_EXCHANGE);
    }

    @Bean
    public Queue deadLetterQueue() {
        return new Queue(DEAD_LETTER_QUEUE);
    }

    @Bean
    public Binding deadLetterBinding() {
        return BindingBuilder.bind(deadLetterQueue()).to(deadLetterExchange()).with(DEAD_LETTER_ROUTING_KEY);
    }

    //=============简单队列模式===============
    public static final String SIMPLE_QUEUE = "simple_queue";

    @Bean
    public Queue queue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE);//设置死信队列
        args.put("x-dead-letter-routing-key", DEAD_LETTER_ROUTING_KEY);//当前队列的死信路由key
        //args.put("x-message-ttl", 6000);
        return QueueBuilder.durable(SIMPLE_QUEUE).withArguments(args).build();
    }

    //===============发布/订阅模式============
    public static final String PS_QUEUE_1 = "ps_queue_1";
    public static final String PS_QUEUE_2 = "ps_queue_2";
    public static final String FANOUT_EXCHANGE = "fanout_exchange";

    @Bean
    public Queue psQueue1() {
        return new Queue(PS_QUEUE_1, true);
    }

    @Bean
    public Queue psQueue2() {
        return new Queue(PS_QUEUE_2, true);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding fanoutBinding1() {
        return BindingBuilder.bind(psQueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBinding2() {
        return BindingBuilder.bind(psQueue2()).to(fanoutExchange());
    }

    //===============路由模式============
    public static final String ROUTING_QUEUE_INFO = "routing_queue_info";
    public static final String ROUTING_QUEUE_ERROR = "routing_queue_error";
    public static final String DIRECT_EXCHANGE = "direct_exchange";

    @Bean
    public Queue routingQueueInfo() {
        return new Queue(ROUTING_QUEUE_INFO, true);
    }

    @Bean
    public Queue routingQueueError() {
        return new Queue(ROUTING_QUEUE_ERROR, true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    public Binding directBinding1() {
        return BindingBuilder.bind(routingQueueInfo()).to(directExchange()).with("info");
    }

    @Bean
    public Binding directBinding2() {
        return BindingBuilder.bind(routingQueueError()).to(directExchange()).with("error");
    }

    //===============主题模式============
    public static final String TOPIC_COLOR_GREEN = "color.green";
    public static final String TOPIC_COLOR_ALL = "color.#";
    public static final String TOPIC_EXCHANGE = "topic_exchange";

    @Bean
    public Queue topicQueueColorGreen() {
        return new Queue(TOPIC_COLOR_GREEN, true);
    }

    @Bean
    public Queue topicQueueColorAll() {
        return new Queue(TOPIC_COLOR_ALL, true);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Binding topicBinding1() {
        return BindingBuilder.bind(topicQueueColorGreen()).to(topicExchange()).with(TOPIC_COLOR_GREEN);
    }

    @Bean
    public Binding topicBinding2() {
        return BindingBuilder.bind(topicQueueColorAll()).to(topicExchange()).with(TOPIC_COLOR_ALL);
    }
}
*/
