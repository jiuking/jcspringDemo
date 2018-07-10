package com.hjc.activeme.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;
import java.util.Map;

/**
 * @author : Administrator
 * @date : 2018/7/10 0010 17:39
 * @description : messageHelper
 */
public class MessageHelper implements InitializingBean {

    @Autowired
    private JmsTemplate jmsQueueTemplate;

    private static JmsTemplate jmsTemplateProxy;

    public JmsTemplate getJmsTemplate() {
        return jmsQueueTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsQueueTemplate = jmsTemplate;
    }

    public static void sendMessage(final Destination destination, final Map<String, Object> map, final String processor) {
        jmsTemplateProxy.send(destination, new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage message = session.createMapMessage();
                message.setString("processor", processor);
                message.setObject("data", map);
                message.setJMSDestination(destination);
                return message;
            }
        });
    }

    public static void sendMessage(final Map<String, Object> map,final String processor) {
        jmsTemplateProxy.send(new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage message = session.createMapMessage();
                message.setObject("processor", processor);
                message.setObject("data", map);
                return message;
            }
        });
    }

    @Override
    public void afterPropertiesSet(){
        jmsTemplateProxy = this.jmsQueueTemplate;
    }

    public static JmsTemplate getJmsTemplateProxy() {
        return jmsTemplateProxy;
    }

    public static void setJmsTemplateProxy(JmsTemplate jmsTemplateProxy) {
        MessageHelper.jmsTemplateProxy = jmsTemplateProxy;
    }

}
