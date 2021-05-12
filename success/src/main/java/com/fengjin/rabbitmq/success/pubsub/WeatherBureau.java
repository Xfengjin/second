package com.fengjin.rabbitmq.success.pubsub;

import com.fengjin.rabbitmq.success.utils.RabbitConstant;
import com.fengjin.rabbitmq.success.utils.RabbitUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author fengjin
 * @Data 2021/5/9
 * @Description 致敬大师，致敬未来的你
 */
public class WeatherBureau {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitUtils.getConnection();
        Channel channel = connection.createChannel();

        while (true) {
            String input = new Scanner(System.in).next();

            // 第一个就是交换机的名字
            channel.basicPublish(RabbitConstant.EXCHANGE_WEATHER, "", null, input.getBytes());
        }

        // channel.close();
        // connection.close();
    }
}
