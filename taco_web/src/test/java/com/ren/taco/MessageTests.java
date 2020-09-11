package com.ren.taco;

import com.ren.taco.model.Order;
import com.ren.taco.service.OrderMessagingService;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/11 9:58
 */
@SpringBootTest
public class MessageTests {
    @Qualifier("jmsOrderMessagingService")
    @Autowired
    private OrderMessagingService jmsService;

    @Qualifier("rabbitOrderMessagingService")
    @Autowired
    private OrderMessagingService rabbitService;

    @Qualifier("kafkaOrderMessagingService")
    @Autowired
    private OrderMessagingService kafkaService;

    @Test
    void sendJmsMessage() {
        Order order = new Order();
        order.setName("test");
        jmsService.sendOrder(order);
    }

    @Test
    void sendRabbitMessage() {
        Order order = new Order();
        order.setName("test");
        rabbitService.sendOrder(order);
    }

    @Test
    void sendKafkaMessage() {
        Order order = new Order();
        order.setName("test");
        kafkaService.sendOrder(order);
    }
}
