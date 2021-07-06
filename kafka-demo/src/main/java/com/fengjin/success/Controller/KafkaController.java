package com.fengjin.success.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: Arno.Feng
 * @date: 2021/7/6
 * @description:生产者
 */
@RestController
public class KafkaController {

    @Value("${topicName}")
    private String topicName;

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/send")
    public void send() {
        kafkaTemplate.send(topicName, 0, "key", "this is a msg");
    }
}
