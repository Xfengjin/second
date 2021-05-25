package com.fengjin.success.batch;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Arno.Feng
 * @date: 2021/5/24
 * @description:
 */
public class SimpleBatchProducer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("BatchProducerGroupName");
        producer.setNamesrvAddr("1.117.82.42:9876");
        producer.start();

        String topic = "BatchTest";
        List<Message> msgs = new ArrayList<>();
        msgs.add(new Message(topic, "Tag", "OrderID001", "Hello world 0".getBytes()));
        msgs.add(new Message(topic, "Tag", "OrderID002", "Hello world 1".getBytes()));
        msgs.add(new Message(topic, "Tag", "OrderID003", "Hello world 2".getBytes()));

        producer.send(msgs);
        producer.shutdown();
    }
}
