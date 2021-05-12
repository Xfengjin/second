package com.fengjin.rabbitmq.success.pubsub;

import com.fengjin.rabbitmq.success.utils.RabbitConstant;
import com.fengjin.rabbitmq.success.utils.RabbitUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author fengjin
 * @Data 2021/5/10
 * @Description 致敬大师，致敬未来的你
 */
public class BaiDu {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(RabbitConstant.QUEUE_BAIDU, false, false, false, null);

        // 将队列与交换机进行绑定
        // 第一个参数是队列，第二个参数是交换机，第三个参数是路由key
        channel.queueBind(RabbitConstant.QUEUE_BAIDU, RabbitConstant.EXCHANGE_WEATHER, "");

        channel.basicQos(1);
        channel.basicConsume(RabbitConstant.QUEUE_BAIDU, false, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("百度天气收到气象信息：" + new String(body));
                // false表示不是自动签收，是手动签收
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }
}
