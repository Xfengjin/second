package com.fengjin.success.simple;

import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author: Arno.Feng
 * @date: 2021/5/25
 * @description:
 */
public class LitePullConsumerSubscribe {

    public static volatile boolean running = true;

    public static void main(String[] args) throws MQClientException {
        DefaultLitePullConsumer consumer = new DefaultLitePullConsumer("lite_pull_consumer_test");
        consumer.setNamesrvAddr("1.117.82.42:9876");
        consumer.subscribe("BatchTest", "*");
        consumer.start();

        try {
            while (running) {
                List<MessageExt> messageExts = consumer.poll();
                System.out.printf("%s%n", messageExts);
            }
        } finally {
            consumer.shutdown();
        }
    }
}
