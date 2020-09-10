package com.ren.kichen.message.jms;

import com.ren.kichen.model.Order;
import com.ren.kichen.service.OrderReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/10 11:06
 */
@Component
public class JmsOrderReceiver implements OrderReceiver {

    private JmsTemplate jms;

    @Autowired
    public JmsOrderReceiver(JmsTemplate jms) {
        this.jms = jms;
    }

    @Override
    public Order receiveOrder() {
        Order order = (Order) jms.receiveAndConvert("order.queue");
        if (order != null) {
            System.out.println("=======jms pull model: " + order.toString());
        }
        return order;
    }
}
