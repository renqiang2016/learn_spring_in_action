package com.ren.learn_spring_in_action.service.impl;

import com.ren.learn_spring_in_action.model.Order;
import com.ren.learn_spring_in_action.service.OrderMessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/9 23:15
 */
@Service
public class JmsOrderMessagingService implements OrderMessagingService {

    private JmsTemplate jms;

    @Autowired
    public JmsOrderMessagingService(JmsTemplate jms) {
        this.jms = jms;
    }

    @Override
    public void sendOrder(Order order) {
        //jms.send(session -> session.createObjectMessage(order));
        jms.convertAndSend(order);
    }
}
