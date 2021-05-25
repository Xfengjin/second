package com.fengjin.success.filter;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * @author: Arno.Feng
 * @date: 2021/5/25
 * @description:
 */
public class TagFilterProducer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        producer.setNamesrvAddr("1.117.82.42:9876");
        producer.start();

        String[] tags = {"TagA", "TagB", "TagC"};

        for (int i = 0; i < 15; i++) {
            Message msg = new Message("TagFilterTest", tags[i % tags.length], "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));

            SendResult send = producer.send(msg);
            System.out.printf("%s%n", send);
        }

        producer.shutdown();
    }
}
