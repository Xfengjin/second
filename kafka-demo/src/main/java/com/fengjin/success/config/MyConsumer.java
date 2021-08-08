package com.fengjin.success.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @author: Arno.Feng
 * @date: 2021/7/6
 * @description:消费者
 */
@Slf4j
@Component
public class MyConsumer {

    /**
     * @KafkaListener(groupId = "testGroup", topicPartitions = {
     *      @TopicPartition(topic = "topic1", partitions = {"0", "1"}),
     *      @TopicPartition(topic = "topic2", partitions = "0",
     *      partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "100"))
     *      },concurrency = "6")
     *
     *      concurrency就是同组下的消费者个数，就是并发消费数，必须小于等于分区总数
     * @param record
     * @param ack
     */
    @KafkaListener(topics = "my-replicated-topic", groupId = "testGroup")
    public void listenTestGroup(ConsumerRecord<String, String> record, Acknowledgment ack) {
        String value = record.value();
        log.info("收到的消息是： -{}", value);
        log.info("收到的记录是： -{}", record);
        // 手动提交offset
        ack.acknowledge();
    }

    /**
     * 配置多个消费组
     * @param record
     * @param ack
     */
    @KafkaListener(topics = "my-replicated-topic",groupId = "tulingGroup")
    public void listenTulingGroup(ConsumerRecord<String, String> record, Acknowledgment ack) {
        String value = record.value();
        log.info("----收到的消息是： -{}", value);
        log.info("----收到的记录是： -{}", record);
        ack.acknowledge();
    }
}
