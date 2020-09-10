package com.ren.taco.service.impl;

import com.ren.taco.model.Order;
import com.ren.taco.service.OrderMessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/10 15:25
 */
@Service
public class KafkaOrderMessagingService implements OrderMessagingService {

    private KafkaTemplate<String, Order> kafka;

    @Autowired
    public KafkaOrderMessagingService(KafkaTemplate<String, Order> kafka) {
        this.kafka = kafka;
    }

    @Override
    public void sendOrder(Order order) {
        //kafka.sendDefault(order);
        kafka.send("taco.orders.topic", order);
    }
}
