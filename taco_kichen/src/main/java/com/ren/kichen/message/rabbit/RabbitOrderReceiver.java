package com.ren.kichen.message.rabbit;

import com.ren.kichen.model.Order;
import com.ren.kichen.service.OrderReceiver;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/10 14:57
 */
@Component
public class RabbitOrderReceiver implements OrderReceiver {
    private RabbitTemplate rabbit;
    private MessageConverter converter;

    @Autowired
    public RabbitOrderReceiver(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
        this.converter = rabbit.getMessageConverter();
    }

    @Override
    public Order receiveOrder() {
        Order order = (Order) rabbit.receiveAndConvert("taco.order");
        if (order != null) {
            System.out.println("=======rabbit pull model: " + order.toString());
        }
        return order;
    }
}
