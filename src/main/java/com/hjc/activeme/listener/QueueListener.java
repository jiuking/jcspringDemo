package com.hjc.activeme.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.Map;

/**
 * @author : Administrator
 * @date : 2018/7/10 0010 17:04
 * @description : 监听队列消息
 */
@Component
public class QueueListener implements MessageListener {

    private static final Logger log = LoggerFactory.getLogger(QueueListener.class);

    @Override
    public void onMessage(Message message) {
        MapMessage msg = (MapMessage) message;
        try {
            String processorName = msg.getString("processor");
            Map<String, Object> param = (Map<String, Object>) msg.getObject("data");
        } catch (JMSException e) {

            log.error("QueueListener on message error|", e);
        }

    }
}
