package com.fengjin.rabbitmq.success.helloworld;

import com.fengjin.rabbitmq.success.utils.RabbitConstant;
import com.fengjin.rabbitmq.success.utils.RabbitUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @author fengjin
 * @Data 2021/5/9
 * @Description 致敬大师，致敬未来的你
 */
public class Consumer {

    public static void main(String[] args) throws IOException {

        // 获取mq的连接
        Connection connection = RabbitUtils.getConnection();
        // 创建通信“通道”， 相当于tcp中的虚拟连接，channel
        Channel channel = connection.createChannel();

        //创建队列,声明并创建一个队列，如果队列已存在，则使用这个队列
        //第一个参数：队列名称ID
        //第二个参数：是否持久化，false对应不持久化数据，MQ停掉数据就会丢失
        //第三个参数：是否队列私有化，false则代表所有消费者都可以访问，true代表只有第一次拥有它的消费者才能一直使用，其他消费者不让访问
        //第四个：是否自动删除,false代表连接停掉后不自动删除掉这个队列
        //其他额外的参数, null
        channel.queueDeclare(RabbitConstant.QUEUE_HELLO_WORLD, false, false, false, null);

        // 开始从MQ服务器中取数据

        // 创建一个消费者
        // 1、队列名
        // 2、是否自动确认消息，false代表手动编程来确认消息，推荐做法
        // 3、DefaultConsumer的实现类
        channel.basicConsume(RabbitConstant.QUEUE_HELLO_WORLD, false, new Receiver(channel));
    }
}
