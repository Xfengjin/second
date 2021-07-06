package com.fengjin.success.kafkademo;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author: Arno.Feng
 * @date: 2021/7/6
 * @description:
 */
@Slf4j
public class MsgConsumer {
    private final static String TOPIC_NAME = "my-replicated-topic";
    private final static String CONSUMER_GROUP_NAME = "testGroup";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "106.15.201.130:9092,106.15.201.130:9093");
        // 消费分组名
        props.put(ConsumerConfig.GROUP_ID_CONFIG, CONSUMER_GROUP_NAME);
        // 是否自动提交offset， 默认是true
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        // props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        // 自动提交offset的时间间隔
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        /**
         * 当消费主题的是一个新的消费组，或者指定offset的消费方式，offset不存在，应该如何消费？
         * latest(默认)：只消费自己启动之后发送到主题的消息
         * earlist: 第一次从头开始消费，以后按照消费的offset记录继续消费，这个需要区别于consumer.seekToBeginning（每次都是从头开始消费）
         */
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        /**
         * consumer给broker发送心跳的时间间隔，broker接收到心跳，如果此时有rebalance发生会通过心跳响应将
         * rebalance方案下发给consumer，这个时间可以稍微短一点
         */
        props.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, 1000);
        /**
         * 服务端broker多久感知不到一个consumer心跳就认为他出故障了，会将其踢出消费组
         * 对应的partition也会被重新分配给其他的consumer，默认是10秒
         */
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 10 * 1000);
        // 一次poll最大拉取消息的长度，如果消费者处理速度很快，可以设置大点，如果处理速度一般，可以设置小点
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 500);
        /**
         * 如果两次poll操作时间间隔超过了这个时间，broker就会认为这个consumer处理能力太弱
         * 会将其踢出消费者组，将会分配给其他的consumer消费
         */
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 30 * 1000);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        // consumer.subscribe(Arrays.asList(TOPIC_NAME));
        // 消费指定分区
        consumer.assign(Arrays.asList(new TopicPartition(TOPIC_NAME, 1)));

        //消息回溯消费
        // consumer.assign(Arrays.asList(new TopicPartition(TOPIC_NAME, 0)));
        // consumer.seekToBeginning(Arrays.asList(new TopicPartition(TOPIC_NAME, 1)));

        // 指定offset消费
        // consumer.assign(Arrays.asList(new TopicPartition(TOPIC_NAME, 0)));
        // consumer.seek(new TopicPartition(TOPIC_NAME, 0), 10);

        // 从指定时间点开始消费
        // List<PartitionInfo> partitionInfos = consumer.partitionsFor(TOPIC_NAME);
        // 从1小时前开始消费
        // long fetchDateTime = System.currentTimeMillis() - 1000 * 60 * 60;
        /*Map<TopicPartition, Long> map = new HashMap<>();
        for (PartitionInfo partitionInfo : partitionInfos) {
            map.put(new TopicPartition(TOPIC_NAME, partitionInfo.partition()),fetchDateTime);
        }
        Map<TopicPartition, OffsetAndTimestamp> praMap = consumer.offsetsForTimes(map);
        for (Map.Entry<TopicPartition, OffsetAndTimestamp> entry : praMap.entrySet()) {
            TopicPartition key = entry.getKey();
            OffsetAndTimestamp value = entry.getValue();
            if (key == null || value == null) {
                continue;
            }
            long offset = value.offset();
            log.info("partition-{} |offset-{}", key.partition(), offset);

            consumer.assign(Arrays.asList(key));
            consumer.seek(key, offset);
        }*/

        while (true) {
            // poll()是拉取消息的长轮询
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                log.info("收到消息：partition = {}, offset = {}, key = {}, value = {}", record.partition(), record.offset(), record.key(),record.value());
            }

            /*if (records.count() > 0) {
                // 手动同步提交offset，当前线程会阻塞直到offset提交成功
                // 一般使用同步提交，因为提交之后一般也没有什么逻辑代码了
                consumer.commitSync();

                // 手动异步提交offset，当前线程提交offset不会阻塞，可以继续处理后面的程序逻辑
                consumer.commitAsync(new OffsetCommitCallback() {
                    @Override
                    public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {
                        if (e != null) {
                            log.error("Commit failed for : -{}", map);
                            log.error("Commit failed exception: -{}", e.getStackTrace());
                        }
                    }
                });
            }*/
        }
    }
}
