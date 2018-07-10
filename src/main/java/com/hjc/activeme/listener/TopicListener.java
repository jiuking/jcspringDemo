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
 * @date : 2018/7/10 0010 17:18
 * @description : topic主题listener
 */
@Component
public class TopicListener implements MessageListener {

    private static final Logger log = LoggerFactory.getLogger(TopicListener.class);

    @Override
    public void onMessage(Message message) {
        MapMessage msg = (MapMessage) message;
        try {
            String processorName = msg.getString("processor");
            log.info("topic:{}",processorName);
            Map<String, Object> param = (Map<String, Object>) msg.getObject("data");
            for (Map.Entry it : param.entrySet()) {
                System.out.println(it.getKey());
            }
        } catch (JMSException e) {
            log.error("TopicListener on message error|", e);
        }
    }

}
