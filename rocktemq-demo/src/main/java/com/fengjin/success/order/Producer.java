package com.fengjin.success.order;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

/**
 * @author: Arno.Feng
 * @date: 2021/5/24
 * @description:
 */
public class Producer {
    public static void main(String[] args) {
        try {
            DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
            producer.setNamesrvAddr("1.117.82.42:9876");
            producer.start();

            for (int i = 0; i < 10; i++) {
                int orderId = i;

                for (int j = 0; j < 5; j++) {
                    Message msg =
                            new Message("OrderTopicTest", "order_" + orderId, "KEY" + orderId,
                                    ("order_" + orderId + " step " + j).getBytes(RemotingHelper.DEFAULT_CHARSET));
                    SendResult send = producer.send(msg, new MessageQueueSelector() {
                        @Override
                        public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                            Integer id = (Integer) o;
                            int index = id % list.size();
                            return list.get(index);
                        }
                    }, orderId);
                    System.out.printf("%s%n", send);
                }
            }
            producer.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
