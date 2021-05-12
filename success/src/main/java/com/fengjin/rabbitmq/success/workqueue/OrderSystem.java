package com.fengjin.rabbitmq.success.workqueue;

import com.fengjin.rabbitmq.success.utils.RabbitConstant;
import com.fengjin.rabbitmq.success.utils.RabbitUtils;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author fengjin
 * @Data 2021/5/9
 * @Description 致敬大师，致敬未来的你
 */
public class OrderSystem {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = RabbitUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(RabbitConstant.QUEUE_SMS, false, false, false, null);
        for (int i = 0; i < 100; i++) {
            SMS sms = new SMS("乘客" + i, "1302300562" + i, "车票预定成功！");
            String s = new Gson().toJson(sms);
            channel.basicPublish("", RabbitConstant.QUEUE_SMS, null, s.getBytes());
            // Thread.sleep(2000);
        }

        System.out.println("数据发送成功");
        channel.close();
        connection.close();
    }
}
