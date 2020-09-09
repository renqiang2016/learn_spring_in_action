package com.ren.learn_spring_in_action.service;

import com.ren.learn_spring_in_action.model.Order;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/9 23:10
 */
public interface OrderMessagingService {

    void sendOrder(Order order);
}
