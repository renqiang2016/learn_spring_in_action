package com.ren.taco.service;

import com.ren.taco.model.Order;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/9 23:10
 */
public interface OrderMessagingService {

    void sendOrder(Order order);
}
