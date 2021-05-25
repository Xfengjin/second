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
 * @date: 2021/5/25
 * @description:
 */
public class SplitBatchProducer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("BatchProducerGroupName");

        producer.setNamesrvAddr("1.117.82.42:9876");
        producer.start();
        String topic = "BatchTest";
        List<Message> msgs = new ArrayList<>(100 * 1000);
        for (int i = 0; i < 100 * 1000; i++) {
            msgs.add(new Message(topic, "Tag", "OrderID" + i, ("Hello world" + i).getBytes()));
        }

        ListSplitter splitter = new ListSplitter(msgs);

        // producer.send(msgs);
        while (splitter.hasNext()) {
            List<Message> next = splitter.next();
            producer.send(next);
        }
        producer.shutdown();
    }
}
