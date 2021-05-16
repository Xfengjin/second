package com.fengjin.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author fengjin
 * @Data 2021/5/16
 * @Description 致敬大师，致敬未来的你
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq-producer.xml")
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 测试confirm模式
     */
    @Test
    public void testConfirm() {

        // 定义回调
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /**
             * @param correlationData 相关的配置信息
             * @param b exchange交换机 是否成功收到了消息，true 成功 false 失败
             * @param s 失败原因
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                if (b) {
                    System.out.println("接受成功消息" + s);
                } else {
                    System.out.println("接受失败消息" + s);
                }
            }
        });

        for (int i = 0; i < 5; i++) {
            rabbitTemplate.convertAndSend("test_exchange_confirm");
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
