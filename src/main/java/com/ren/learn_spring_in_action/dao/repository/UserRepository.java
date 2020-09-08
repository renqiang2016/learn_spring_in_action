package com.ren.learn_spring_in_action.dao.repository;

import com.ren.learn_spring_in_action.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/8 9:43
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String userName);
}
