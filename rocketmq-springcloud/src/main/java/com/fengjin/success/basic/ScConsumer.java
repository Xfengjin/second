package com.fengjin.success.basic;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

/**
 * @author: Arno.Feng
 * @date: 2021/5/27
 * @description:
 */
@Component
public class ScConsumer {

    @StreamListener(Sink.INPUT)
    public void onMessage(String message) {
        System.out.println("received message:" + message + "from binding:" + Sink.INPUT);
    }
}
