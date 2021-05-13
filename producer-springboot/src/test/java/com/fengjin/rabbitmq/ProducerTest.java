package com.fengjin.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author fengjin
 * @Data 2021/5/13
 * @Description 致敬大师，致敬未来的你
 */
@SpringBootTest
public class ProducerTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test() {
        rabbitTemplate.convertAndSend("boot_topic_exchange","boot.haha","boot mq...");
    }
}
