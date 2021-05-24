package com.fengjin.success.simple;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @author fengjin
 * @Data 2021/5/22
 * @Description 致敬大师，致敬未来的你
 */
public class Producer {
    public static void main(String[] args) throws MQClientException {
        // 基本样例：同步发送消息
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");

        producer.setNamesrvAddr("1.117.82.42:9876");
        producer.start();
        for (int i = 0; i < 20; i++) {
            try {
                Message message = new Message("TopicTest",
                        "TagA",
                        "OrderID188",
                        "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));

                //同步传递消息，消息会发给集群中的一个Broker节点。
                //SendResult send = producer.send(message);
                //System.out.printf("%s%n", send);

                producer.sendOneway(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        producer.shutdown();
    }
}
