package com.ren.taco_flux_web.repository;

import com.ren.taco_flux_web.model.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/7 16:07
 */
public interface OrderRepository extends ReactiveMongoRepository<Order, String> {

}
