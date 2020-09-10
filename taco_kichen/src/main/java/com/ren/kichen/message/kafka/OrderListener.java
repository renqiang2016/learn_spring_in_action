package com.ren.kichen.message.kafka;

import com.ren.kichen.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/10 16:16
 */
@Slf4j
@Component
public class OrderListener {
    @KafkaListener(topics = "taco.orders.topic")
    public void receiveOrder(Order order) {
        System.out.println("=======kafka listener model: " + order.toString());
    }

    @KafkaListener(topics = "taco.orders.topic")
    public void receiveOrder(Order order, ConsumerRecord<String, Order> record) {
        log.info("Received from partition {} with timestamp {}",
                record.partition(), record.timestamp());
        System.out.println("=======kafka listener model: " + order.toString());
    }
}
