package com.fengjin.rabbitmq.listener.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * @author fengjin
 * @Data 2021/5/16
 * @Description 致敬大师，致敬未来的你
 */
@Component
public class AckListener implements ChannelAwareMessageListener {
    @Override
    @RabbitListener(queues = "boot_queue")
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = 0;
        try {
            // 获取消息的id
            deliveryTag = message.getMessageProperties().getDeliveryTag();

            // 获取消息
            System.out.println("message   " + new String(message.getBody()));

            // 进行业务处理
            System.out.println("========进行业务处理==========");

            // 模拟出现异常
            int i = 5/0;

            //进行消息签收
            System.out.println("收到了消息：" + deliveryTag);
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            //拒绝签收
             /*
            第三个参数：requeue：重回队列。如果设置为true，则消息重新回到queue，broker会重新发送该消息给消费端
             */
             channel.basicNack(deliveryTag, false, true);
        }
    }

    /*@Override
    public void onMessage(Message message) {

    }

    @Override
    public void onMessageBatch(List<Message> messages, Channel channel) {

    }*/
}
