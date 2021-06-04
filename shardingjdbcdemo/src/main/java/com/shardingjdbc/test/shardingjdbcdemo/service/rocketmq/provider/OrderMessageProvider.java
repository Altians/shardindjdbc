package com.shardingjdbc.test.shardingjdbcdemo.service.rocketmq.provider;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderMessageProvider {

    DefaultMQProducer producer = new DefaultMQProducer("orderGroup");
    private static final String[] ORDER_MESSAGES = {"下单", "结算", "支付", "完成"};

    public void sendMessage() {

        try {
            producer.setNamesrvAddr("127.0.0.1");
            producer.setInstanceName("Test-insurance");
            producer.start();

            String topic = "TestTopic";
            String tags = "TestTag";
            OrderMessageQueueSelector selector = new OrderMessageQueueSelector();
            for (int i = 0; i < ORDER_MESSAGES.length; i++) {
                String message = "order-" + i + ORDER_MESSAGES[i];
                String keys = message;
                byte[] bytes = message.getBytes(RemotingHelper.DEFAULT_CHARSET);
                Message msg = new Message(topic, tags, keys, bytes);
                //实现顺序消费，要同步发送
                producer.send(msg, selector, i);
            }
/**
 * 使用DefaultMQProducer的send()方法，指定MessageQueueSelector和参数，Broker将会将逻辑上需要保证顺序性的消息发往同一队列。
 * 注：想要实现顺序消费，发送方式必须为同步发送，异步发送无法保证消息的发送顺序！
 */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        //官网的实例.
        MQProducer producer = new DefaultMQProducer("example_group_name");
        //Launch the instance.
        producer.start();
        String[] tags = new String[]{"TagA", "TagB", "TagC", "TagD", "TagE"};
        for (int i = 0; i < 100; i++) {
            int orderId = i % 10;
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicTestjjj", tags[i % tags.length], "KEY" + i,
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    Integer id = (Integer) arg;
                    int index = id % mqs.size();
                    return mqs.get(index);
                }
            }, orderId);
        }
    }
}
