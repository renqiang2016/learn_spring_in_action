package com.ren.taco.service.impl;

import com.ren.taco.model.Order;
import com.ren.taco.service.OrderMessagingService;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/10 14:38
 */
@Service
public class RabbitOrderMessagingService implements OrderMessagingService {

    private RabbitTemplate rabbit;

    @Autowired
    public RabbitOrderMessagingService(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

    @Override
    public void sendOrder(Order order) {
        rabbit.convertAndSend("taco.order", order, message -> {
            message.getMessageProperties().setHeader("X_ORDER_SOURCE", "WEB");
            return message;
        });
    }
}
