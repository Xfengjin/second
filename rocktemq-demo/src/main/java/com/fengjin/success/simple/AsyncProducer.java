package com.fengjin.success.simple;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: Arno.Feng
 * @date: 2021/5/24
 * @description:
 */
public class AsyncProducer {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        // 简单样例，异步发送消息
        DefaultMQProducer producer = new DefaultMQProducer("Jodie_Daily_test");

        producer.setNamesrvAddr("1.117.82.42:9876");
        producer.start();
        producer.setRetryTimesWhenSendAsyncFailed(0);

        int messageCount = 100;
        // 由于是异步发送，这里引入了一个countdownLatch，保证所有的producer发送消息的回调方法都执行完了在停止producer服务
        final CountDownLatch countDownLatch = new CountDownLatch(messageCount);
        for (int i = 0; i < messageCount; i++) {
            try {
                final int index = i;
                Message msg = new Message("TopicTest",
                        "TagA",
                        "OrderID18111",
                        "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));

                producer.send(msg, new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        countDownLatch.countDown();
                        System.out.printf("%-10d OK %s %n", index, sendResult.getMsgId());
                    }

                    @Override
                    public void onException(Throwable e) {
                        countDownLatch.countDown();
                        System.out.printf("%-10d Exception %s %n", index, e);
                        e.printStackTrace();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        countDownLatch.await(5, TimeUnit.SECONDS);
        producer.shutdown();
    }
}
