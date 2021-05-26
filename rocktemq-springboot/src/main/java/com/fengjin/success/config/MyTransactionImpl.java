package com.fengjin.success.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.apache.rocketmq.spring.support.RocketMQUtil;
import org.springframework.messaging.Message;
import org.springframework.messaging.converter.StringMessageConverter;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Arno.Feng
 * @date: 2021/5/26
 * @description:
 */
@RocketMQTransactionListener(rocketMQTemplateBeanName = "rocketMQTemplate")
public class MyTransactionImpl implements RocketMQLocalTransactionListener {

    private ConcurrentHashMap<Object, Message> localTrans = new ConcurrentHashMap<>();

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        Object transId = message.getHeaders().get(RocketMQHeaders.PREFIX + RocketMQHeaders.TRANSACTION_ID);
        String destination = o.toString();
        //这个message的实现类是GenericMessage，里面实现了toString方法
        //在Header中自定义的RocketMQHeaders.TAGS属性，到这里就没了。但是RocketMQHeaders.TRANSACTION_ID这个属性就还在。
        //而message的Header里面会默认保存RocketMQHeaders里的属性，但是都会加上一个RocketMQHeaders.PREFIX前缀
        localTrans.put(transId, message);
        System.out.println("executeLocalTransaction msg = "+message);
        org.apache.rocketmq.common.message.Message msg
                = RocketMQUtil.convertToRocketMessage(new StringMessageConverter(), "UTF-8", destination, message);
        String tags = msg.getTags();
        if(StringUtils.contains(tags,"TagA")){
            return RocketMQLocalTransactionState.COMMIT;
        }else if(StringUtils.contains(tags,"TagB")){
            return RocketMQLocalTransactionState.ROLLBACK;
        }else{
            return RocketMQLocalTransactionState.UNKNOWN;
        }
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        String transId = message.getHeaders().get(RocketMQHeaders.PREFIX + RocketMQHeaders.TAGS).toString();
        Message originalMessage = localTrans.get(transId);
        // 这里能够获取到自定义的transaction_id属性
        System.out.println("checkLocalTransaction msg = "+originalMessage);
        // 获取标签时，自定义的RocketMQHeaders.TAGS拿不到，但是框架会封装成一个带RocketMQHeaders.PREFIX的属性
        String tags = message.getHeaders().get(RocketMQHeaders.PREFIX + RocketMQHeaders.TAGS).toString();
        if(StringUtils.contains(tags,"TagC")){
            return RocketMQLocalTransactionState.COMMIT;
        }else if(StringUtils.contains(tags,"TagD")){
            return RocketMQLocalTransactionState.ROLLBACK;
        }else{
            return RocketMQLocalTransactionState.UNKNOWN;
        }
    }
}
