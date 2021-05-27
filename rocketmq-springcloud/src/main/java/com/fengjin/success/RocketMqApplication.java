package com.fengjin.success;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author: Arno.Feng
 * @date: 2021/5/27
 * @description:
 */
@EnableBinding({Source.class, Sink.class})
@SpringBootApplication
public class RocketMqApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketMqApplication.class, args);
    }
}
