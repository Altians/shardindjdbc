package com.shardingjdbc.test.shardingjdbcdemo.service.rocketmq.provider;

import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * 自定义MessageQueueSelector，根据发送消息时传递的参数，选择指定的MessageQueue
 */
public class OrderMessageQueueSelector implements MessageQueueSelector {

    @Override
    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
        Integer id = (Integer) arg;
        int index = id % mqs.size();
        return mqs.get(index);
    }
}
