package com.fengjin.success.basic;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author: Arno.Feng
 * @date: 2021/5/26
 * @description:
 */
@Component
@RocketMQMessageListener(consumerGroup = "MyConsumerGroup", topic = "TopicTest", consumeMode = ConsumeMode.CONCURRENTLY)
public class SpringConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("Received message ：" + s);
    }
}
