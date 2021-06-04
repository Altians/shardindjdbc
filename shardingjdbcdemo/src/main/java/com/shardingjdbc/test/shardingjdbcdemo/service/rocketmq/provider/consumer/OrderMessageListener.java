package com.shardingjdbc.test.shardingjdbcdemo.service.rocketmq.provider.consumer;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 消息监听器
 */
public class OrderMessageListener implements MessageListenerOrderly {
    @Override
    public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
        if (CollectionUtils.isEmpty(msgs)){
            return ConsumeOrderlyStatus.SUCCESS;
        }
        //遍历消息
        msgs.forEach(msg ->{
            try {
                byte[] msgBody = msg.getBody();
                String str = new String(msgBody, RemotingHelper.DEFAULT_CHARSET);
                System.out.println("handle message body"+str+"message id"+msg.getMsgId()
                        +"keys:"+msg.getKeys()+"topic:"+msg.getTopic()+"tags:"+msg.getTags());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return ConsumeOrderlyStatus.SUCCESS;
    }
}
