package com.fengjin.success.kafkademo;

import com.alibaba.fastjson.JSON;
import com.fengjin.success.bean.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: Arno.Feng
 * @date: 2021/7/6
 * @description:
 */
@Slf4j
public class MsgProducer {
    private final static String TOPIC_NAME = "my-replicated-topic";

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "106.15.201.130:9092,106.15.201.130:9093");
        /**
         * 发消息的持久化参数机制
         * 1、acks=0，表示producer不需要等待任何broker确认收到消息的回复，就可以继续发送下一条消息。性能最高，但是丢消息的风险最高
         * 2、acks=1，至少要等待leader已经成功将数据写进本地log（但是不需要等待所有的follower都成功写入），就可以继续发送下一条消息。
         *  这种情况下，如果follower没有成功备份数据，而此时leader又挂掉，则消息会丢失。
         * 3、acks=1/all，需要等待 min.insync.replicas（默认是1，推荐配置大于1或者等于2）这个参数配置的副本个数都成功写入日志，
         *  这种策略会保证只要有一个备份存活就不会丢失数据。这个是最强的数据保证，一般除非是金融级别，或跟钱打交道的场景才会使用这种配置。
         */
        props.put(ProducerConfig.ACKS_CONFIG, "1");
        /**
         * 发送失败会重试，默认重试的间隔是100ms，重试能保证消息发送的可靠性，但是也可能造成消息的重复发送。比如在网络抖动，
         * 所以需要在接收者端做好消息幂等性处理
         */
        props.put(ProducerConfig.RETRIES_CONFIG, 3);
        // 重试的时间间隔
        props.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, 300);
        // 设置发送消息的本地缓冲区，如果设置了该缓冲区，消息会先发送到本地缓冲区，可以提高消息发送的性能，默认值是33554432，即32M
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        /**
         * kafka本地线程会从缓冲区取数据，批量发送到broker
         * 设置批量发送消息的大小，默认值是16384，即16KB, 就是说一个batch满了16KB就会发送出去
         */
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        /**
         * 默认值是0，意思就是消息必须立即被发送，但是这样会影响性能
         * 一般设置在10毫秒左右，就是说这个消息发送完后会进入本地的一个batch，
         * 如果10毫秒内，这个batch满了16KB就会随batch一起被发送出去
         * 如果10毫秒之内，这个batch没有满，也要将消息发送出去，不能让消息的发送时间延迟太久
         */
        props.put(ProducerConfig.LINGER_MS_CONFIG, 10);
        // 把发送的key从字符串序列化为字节数组
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // 把发送的key从字符串序列化为字节数组
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        int msgNum = 5;
        final CountDownLatch countDownLatch = new CountDownLatch(msgNum);
        for (int i = 0; i < msgNum; i++) {
            Order order = new Order(i, 100 + i, 1, 1000.00);
            // 指定发送分区
            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(TOPIC_NAME, 0, order.getOrderId().toString(), JSON.toJSONString(order));
            // 未指定发送的分区，具体发送的分区计算公式： hash(key)%partitionNum
            // ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(TOPIC_NAME, order.getOrderId().toString(), JSON.toJSONString(order));

            // 等待消息发送成功的同步阻塞方法
            /*RecordMetadata metadata = producer.send(producerRecord).get();
            log.info("同步方式发送消息的结果：" + "topic - " + metadata.topic() + "|partition-" + metadata.partition() + "|offset-1" + metadata.offset());*/

            // 异步回调方式发送消息
            producer.send(producerRecord, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e != null) {
                        log.error("发送消息失败： -{}", e.getStackTrace());
                    }
                    if (recordMetadata != null) {
                        log.info("异步方式发送消息结果： topic-{} |partition-{} |offset-{}", recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset());
                    }
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await(5, TimeUnit.SECONDS);
        producer.close();
    }
}
