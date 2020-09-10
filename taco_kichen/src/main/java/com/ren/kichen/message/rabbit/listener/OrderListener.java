package com.ren.kichen.message.rabbit.listener;

import com.ren.kichen.model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/10 15:21
 */
@Component
public class OrderListener {

    @RabbitListener(queues = "taco.order")
    public void receiveOrder(Order order) {
        System.out.println("=======rabbit listener model: " + order.toString());
    }
}
