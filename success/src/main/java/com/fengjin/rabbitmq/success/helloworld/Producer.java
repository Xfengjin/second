package com.fengjin.rabbitmq.success.helloworld;

import com.fengjin.rabbitmq.success.utils.RabbitConstant;
import com.fengjin.rabbitmq.success.utils.RabbitUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author fengjin
 * @Data 2021/4/29
 * @Description 致敬大师，致敬未来的你
 */
public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {

        // 获取TCP长连接
        Connection connection = RabbitUtils.getConnection();
        // 创建通信通道，相当于TCP中的虚拟连接
        Channel channel = connection.createChannel();

        // 创建队列，声明并创建一个队列，如果队列存在，则使用这个队列
        // 第一个参数：队列的名称ID
        // 第二个参数：是否持久化，false对应不持久化的数据，MQ停止数据就会丢失
        // 第三个参数：是否队列私有化，false则代表所有的消费者都可以访问，true代表只有第一次拥有它的消费者才能一直使用，其他访问者不让访问
        // 第四个参数：是否自动删除，false代表连接停掉之后不自动删除队列
        // 其他额外的参数
        channel.queueDeclare(RabbitConstant.QUEUE_HELLO_WORLD, false, false, false, null);

        String message = "hello fengjin success";
        //exchange 交换机，暂时用不到，在后面进行发布订阅时才会用到
        //队列名称
        //额外的设置属性
        //最后一个参数是要传递的消息字节数组
        channel.basicPublish("", RabbitConstant.QUEUE_HELLO_WORLD, null, message.getBytes());

        channel.close();
        connection.close();

        System.out.println("==========发送成功=================");
    }
}
