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
    public void test() throws InterruptedException {

        /*// 定义回调
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /**
             * @param correlationData 相关的配置信息
             * @param b exchange交换机 是否成功收到了消息，true 成功 false 失败
             * @param s 失败原因
             *//*
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                if (b) {
                    System.out.println("接受成功消息" + s);
                } else {
                    System.out.println("接受失败消息" + s);
                }
            }
        });*/

        rabbitTemplate.convertAndSend("boot_topic_exchange","boot.haha","boot mq...");


        Thread.sleep(2000);
    }
}
