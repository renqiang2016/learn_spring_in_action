package com.ren.kichen.message.jms.listener;

import com.ren.kichen.model.Order;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/10 11:41
 */
@Component
public class JmsOrderListener {
    @JmsListener(destination = "order.queue")
    public void receiveOrder(Object order) {
        System.out.println("=======jms listener model: " + order.toString());
    }
}
