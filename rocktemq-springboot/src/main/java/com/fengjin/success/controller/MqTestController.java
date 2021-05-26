package com.fengjin.success.controller;

import com.fengjin.success.basic.SpringProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Arno.Feng
 * @date: 2021/5/26
 * @description:
 */
@RestController
@RequestMapping("/MQTest")
public class MqTestController {

    @Value("${rocketmq.topic}")
    private String topic;

    @Autowired
    private SpringProducer springProducer;

    @GetMapping("/sendMessage")
    public String sendMessage(String message) {
        System.out.println("当前的topic是：" + topic);
        springProducer.sendMessage(topic, message);
        return "消息发送完成";
    }

    @GetMapping("/sendTransactionMessage")
    public String sendTransactionMessage(String message) throws InterruptedException {
        springProducer.sendMessageInTransaction(topic, message);
        return "消息发送完成";
    }
}
