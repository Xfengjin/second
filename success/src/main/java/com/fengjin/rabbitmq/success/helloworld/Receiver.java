package com.fengjin.rabbitmq.success.helloworld;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * @author fengjin
 * @Data 2021/5/9
 * @Description 致敬大师，致敬未来的你
 */
public class Receiver extends DefaultConsumer {

    private Channel channel;
    // 重写构造函数，Channel通道对象需要从外层传入
    public Receiver(Channel channel) {
        super(channel);
        this.channel = channel;
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        String msg = new String(body);
        System.out.println("消费者接收到的消息是：" + msg);

        System.out.println("消息的TagId:" + envelope.getDeliveryTag());
        // false只确认签收当前的消息，设置为true的时候则代表签收该消费者所有未签收的消息
        channel.basicAck(envelope.getDeliveryTag(), false);
    }
}
