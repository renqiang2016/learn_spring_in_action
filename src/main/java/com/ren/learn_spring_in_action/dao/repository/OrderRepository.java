package com.ren.learn_spring_in_action.dao.repository;

import com.ren.learn_spring_in_action.model.Order;
import com.ren.learn_spring_in_action.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/7 16:07
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByUserOrderByCreatedAtDesc(User user, Pageable pageable);
}
