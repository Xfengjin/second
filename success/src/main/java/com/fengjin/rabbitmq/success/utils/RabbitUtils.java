package com.fengjin.rabbitmq.success.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author fengjin
 * @Data 2021/4/29
 * @Description 致敬大师，致敬未来的你
 */
public class RabbitUtils {

    private static ConnectionFactory connectionFactory = new ConnectionFactory();

    static {
        connectionFactory.setHost("192.168.124.14");
        connectionFactory.setPort(5672); // 5672是rabbaitmq默认端口号
        connectionFactory.setUsername("fengj");
        connectionFactory.setPassword("fengj");
        connectionFactory.setVirtualHost("fengJ");
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = connectionFactory.newConnection();
            return connection;
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
