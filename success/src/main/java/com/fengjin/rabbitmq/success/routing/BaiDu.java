package com.fengjin.rabbitmq.success.routing;

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
        // 通过routing key，指定交换机和队列之间的关系
        channel.queueBind(RabbitConstant.QUEUE_BAIDU, RabbitConstant.EXCHANGE_WEATHER_ROUTING, "china.hunan.changsha.20201127");
        channel.queueBind(RabbitConstant.QUEUE_BAIDU, RabbitConstant.EXCHANGE_WEATHER_ROUTING, "china.hebei.shijiazhuang.20201128");
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
