package com.fengjin.success.basic;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author: Arno.Feng
 * @date: 2021/5/26
 * @description:
 */
@Component
@Slf4j
public class SpringProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void sendMessage(String topic, String msg) {
        log.info("start to send message");
        this.rocketMQTemplate.convertAndSend(topic, msg);
    }

    public void sendMessageInTransaction(String topic, String msg) throws InterruptedException {
        String[] tags = new String[]{"TagA", "TagB", "TagC", "TagD", "TagE"};
        for (int i = 0; i < 10; i++) {
            // 尝试在header中加入一些自定义属性
            Message<String> message = MessageBuilder.withPayload(msg)
                    .setHeader(RocketMQHeaders.TRANSACTION_ID, "TransID_" + i)
                    // 发到事务监听里后，这个自己设定的TAGS属性就会丢失，但是上面的那个属性不会丢失
                    .setHeader(RocketMQHeaders.TAGS, tags[i % tags.length])
                    .setHeader("MyProp", "MyProp" + i)
                    .build();

            String destination = topic + ":" + tags[i % tags.length];

            TransactionSendResult sendResult = rocketMQTemplate.sendMessageInTransaction(destination, message, destination);
            System.out.printf("%s%n", sendResult);

            Thread.sleep(10);
        }
    }
}
