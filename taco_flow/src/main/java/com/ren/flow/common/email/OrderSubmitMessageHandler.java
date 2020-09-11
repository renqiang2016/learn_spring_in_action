package com.ren.flow.common.email;

import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/10 21:41
 */
@Component
public class OrderSubmitMessageHandler
        implements GenericHandler<Order> {

    private RestTemplate rest;
    private ApiProperties apiProps;

    public OrderSubmitMessageHandler(ApiProperties apiProps, RestTemplate rest) {
        this.apiProps = apiProps;
        this.rest = rest;
    }

    @Override
    public Object handle(Order order, MessageHeaders messageHeaders) {
        rest.postForObject(apiProps.getUrl(), order, String.class);
        return null;
    }
}
