package com.fengjin.success.controller;

import com.fengjin.success.basic.ScProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Arno.Feng
 * @date: 2021/5/27
 * @description:
 */
@RestController
@RequestMapping("/MQTest")
public class MQTestController {

    @Autowired
    private ScProducer scProducer;

    @RequestMapping("/sendMessage")
    public String sendMessage(String message) {
        scProducer.sendMessage(message);

        return "消息发送完成";
    }
}
