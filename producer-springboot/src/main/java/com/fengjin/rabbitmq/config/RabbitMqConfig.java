package com.fengjin.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fengjin
 * @Data 2021/5/13
 * @Description 致敬大师，致敬未来的你
 */
@Configuration
public class RabbitMqConfig {

    public static final String EXCHANGE_NAME = "boot_topic_exchange";

    public static final String QUEUE_NAME = "boot_queue";

    // 声明交换机
    @Bean("bootExchange")
    public Exchange bootExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    // 声明队列
    @Bean("bootQueue")
    public Queue bootQueue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    // 队列与交换机进行绑定
    @Bean
    public Binding bindQueueExchange(@Qualifier("bootQueue") Queue queue,
                                     @Qualifier("bootExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("boot.#").noargs();
    }

}
